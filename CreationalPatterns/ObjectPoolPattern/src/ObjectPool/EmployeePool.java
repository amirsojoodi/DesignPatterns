package ObjectPool;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeePool extends ObjectPool<Employee> {
    public EmployeePool(long expirationTime) {
        super(expirationTime);
    }

    public EmployeePool(Long expirationTime, HashMap<Employee, Long> available, HashMap<Employee, Long> inUse) {
        super(expirationTime, available, inUse);
    }

    @Override
    Employee createNew() {
        // Hire a new Employee
        String name = Employee.possibleNames.get(ThreadLocalRandom.current().nextInt(Employee.possibleNames.size()));
        Employee.possibleNames.remove(name);
        return new Employee(name);
    }

    @Override
    boolean validate(Employee object) {
        // Check if he/she is still an employee
        return !(object.getName().isEmpty());
    }

    @Override
    void expire(Employee object) {
        // Fire employee
        object.setName("");
    }
}
