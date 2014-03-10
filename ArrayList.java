import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

  public static void main(String args[]) {
    ArrayList<Person> persons = new ArrayList<Person>();    // create a container
    Person p1 = new Person("Jones",10);
    Person p2 = new Person("Smith",20);
    Person p3 = new Person("Adams",30);
    persons.add(p1);                                        // add objects to the end of the list
    persons.add(p2);
    persons.add(p3);

    for (Person p : persons)                                // foreach member of the list
      System.out.println(p);

    Iterator<Person> it = persons.iterator();               // iterator technique
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    persons.remove(0);                                      // remove Jones based on index
    persons.add(1,p1);                                      // insert Jones after Smith
    persons.remove(p3);                                     // remove Adams based on object
    
    for (Person p : persons)                                // print again
      System.out.println(p);                                // Smith, Jones
  }
}
