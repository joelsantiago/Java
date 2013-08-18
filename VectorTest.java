import java.util.Vector;
import java.util.Iterator;

public class VectorTest {

  public static void main(String args[]) {
    Vector v = new Vector();                 // create a container
    Person p1 = new Person("Jones",10);      // create new objects
    Person p2 = new Person("Smith",20);
    Person p3 = new Person("Adams",30);
    v.addElement(p1);                        // add objects to the end of the list
    v.addElement(p2);
    v.addElement(p3);                                          
    for (int i=0; i<v.size(); i++) {         // iterate through the list 0..size()-1
       Person p = (Person)v.elementAt(i);    // cast as Person, retrieve object at i
       System.out.println(p);                // Jones, Smith, Adams
    }
   
    Iterator it = v.iterator();               // iterator technique
    while (it.hasNext()) {
      Person p = (Person)it.next();           // can retrieve into Person
      System.out.println(p);       
      // System.out.println(it.next());       // or print directly using toString(), 
    }                                         // but don't do two next(), it will skip

    v.removeElementAt(0);                    // remove Jones based on index
    v.insertElementAt(p1,1);                 // insert Jones after Smith
    v.removeElement(p3);                     // remove Adams based on object
    
    for (int i=0; i<v.size(); i++) {         // print again
       Person p = (Person)v.elementAt(i);
       System.out.println(p);                // Smith, Jones
    }
  }
}
