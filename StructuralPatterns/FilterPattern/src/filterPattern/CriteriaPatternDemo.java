package filterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPatternDemo {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("Tom", "Male", "Single"));
        persons.add(new Person("Jerry", "Male", "Married"));
        persons.add(new Person("Alice", "Female", "Married"));
        persons.add(new Person("Liz", "Female", "Single"));
        persons.add(new Person("Alex", "Male", "Single"));
        persons.add(new Person("David", "Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AddCriteria(single, male);
        Criteria singleOrFemale = new OrCriteria(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));
        
        System.out.println("Femles: ");
        printPersons(female.meetCriteria(persons));
        
        System.out.println("Singles: ");
        printPersons(single.meetCriteria(persons));
        
        System.out.println("Single Males: ");
        printPersons(singleMale.meetCriteria(persons));
        
        System.out.println("Single or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));

    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(
                "Person: [Name : " + person.getName() + ", Gender: " + person.getGender()
                        + ", Marital Status: " + person.getMartialStatus() + "]");
        }
    }
}
