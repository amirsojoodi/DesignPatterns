package compositePattern;

public class CompositePatternDemo {

    public static void main(String[] args) {
        Employee CEO = new Employee("Kalam", "CEO", 50000);

        Employee headSales = new Employee("Havij", "Head Sales", 40000);

        Employee headMarketing = new Employee("Sheved", "Head Marketing", 40000);

        Employee clerk1 = new Employee("Alice", "Marketing", 30000);
        Employee clerk2 = new Employee("Bob", "Marketing", 30000);

        Employee salesExecutives1 = new Employee("Dara", "Sales", 30000);
        Employee salesExecutives2 = new Employee("Sara", "Sales", 30000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        headSales.add(salesExecutives1);
        headSales.add(salesExecutives2);

        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
