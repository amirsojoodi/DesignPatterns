package filterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getMartialStatus().equalsIgnoreCase("Single")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }

}
