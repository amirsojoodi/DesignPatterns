package ObjectPool;

import java.util.*;

abstract public class ObjectPool<O> {
    // Factory method pattern can help in creating
    // ObjectPools and it's elements (like O).
    private Long expirationTime;
    private HashMap<O, Long> available = new HashMap<>();  // "unlocked" objects
    private HashMap<O, Long> inUse = new HashMap<>();      // "locked" objects

    public ObjectPool(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public ObjectPool(Long expirationTime, HashMap<O, Long> available, HashMap<O, Long> inUse) {
        this.expirationTime = expirationTime;
        this.available = available;
        this.inUse = inUse;
    }

    // createNew will be called when there isn't enough instances of O
    abstract O createNew();

    // validate is used to check if the object can be reused
    abstract boolean validate(O object);

    // expire will be called after removing object from pool
    abstract void expire(O object);

    // checkOut will give you a new instance of O
    public synchronized O checkOut() {
        Long now = System.currentTimeMillis();
        O returnObj = null;

        for (Iterator<HashMap.Entry<O, Long>> it = available.entrySet().iterator(); it.hasNext();) {
            HashMap.Entry<O, Long> entry = it.next();
            O object = entry.getKey();
            Long then = entry.getValue();

            if (now - then > expirationTime) {
                // object has expired, free object
                it.remove();
                expire(object);
                //noinspection UnusedAssignment
                object = null; // for GC
            } else { // Object is available,
                if (validate(object)) { // but is it usable?
                    // Yes, it's usable and good. So give it away
                    it.remove();
                    inUse.put(object, now);
                    if (returnObj == null) // Can replaced with a return statement
                        returnObj = object;
                } else { // Nope, it's not usable. Free object
                    it.remove();
                    expire(object);
                    //noinspection UnusedAssignment
                    object = null; // for GC
                }
            }
        }
        if (returnObj != null)
            return returnObj;

        // Create a new object and return it
        returnObj = createNew();
        inUse.put(returnObj, now);
        return returnObj;
    }

    // Call checkIn when you're done with object
    public synchronized void checkIn(O object) {
        inUse.remove(object);
        available.put(object, System.currentTimeMillis());
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
