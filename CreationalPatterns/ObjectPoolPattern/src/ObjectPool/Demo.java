package objectPool;

public class Demo {
    public static void main(String[] args) {
        // We don't need to create Employee instances manually.
        // EmployeePool will take care of that.
        EmployeePool employeePool = new EmployeePool(1000L); // 1 sec
        Employee employeeA = employeePool.checkOut();
        Employee employeeB = employeePool.checkOut();

        employeeA.doStuff();
        employeeB.doStuff();
        employeePool.checkIn(employeeA);
        employeePool.checkIn(employeeB);

        // Comment this block and the employee won't be fired (object in pool will not expire).
        // Changing sleep time and expirationTime(of the pool) will yield the same result.
        try {
            Thread.sleep(1001L);
        } catch (InterruptedException e) {
            System.out.println("woke up too early, employee won't get fired :(");
        }

        Employee employeeC = employeePool.checkOut();
        employeeC.doStuff();
        employeePool.checkIn(employeeC);
    }
}
