import java.util.ArrayList;
import java.util.Iterator;

public class CompositePattern {
  public static void main(String args[]) {
    Composite                               // declare Composites A..D
      a = new A(),
      b = new B(),
      c = new C(),
      d = new D();
    Element                                 // declare ordinary Elements E..I
      e = new E(),
      f = new F(),
      g = new G(),
      h = new H(), 
      i = new I();

    a.add(b);                               // add will put the Element into Composite's ArrayList
    a.add(c);                               // a has children b, c, d
    a.add(d);
    b.add(e);                               // b has children e, f
    b.add(f);
    c.add(g);                               // c has children g, h
    c.add(h);
    d.add(i);                               // d just has child I
  
    // call getTotal() on "a" (the root), this will iterate through the entire tree  
    System.out.println("Grand Total: " + a.getTotal()); 
  }
}

interface Element {                         // all Elements must have a getTotal() method
  int getTotal();
}

abstract class Composite implements Element {    // Composite must have a getTotal() method
  // here is the container of MANY children
  // note the use of the generic <Element> as in Ex6 
  private ArrayList<Element> elements = new ArrayList<Element>();
  public void add(Element e) {
    elements.add(e);                             // just use the container to store the Element
  }
  public void remove(Element e) {
    elements.remove(e);                          // remove from container
  }
  public int getTotal() {                        // all Composites will inherit this method 
    int total = 0;                               // and will not need to reprogram
    
    // the simpler, powerful way to iterate using foreach: 
    for (Element e : elements)
      total += e.getTotal();                     // this will do the accumulation throughout the tree
      
    /* this is the iterator way:
    Iterator<Element> it = elements.iterator();
    while (it.hasNext()) {
      Element e = it.next();    
      total += e.getTotal();
    }
    */
    return total;
  }
}
 
class A extends Composite { }                    // A..D do not necessarily need any special code
class B extends Composite { }
class C extends Composite { 
  public int getTotal() {                        // but C can overload getTotal() and 
    return 1 + super.getTotal();                 // add an extra 1 to the normal summation
  }
}
class D extends Composite { }
class E implements Element {                     // E..I getTotal() return specialized results
  public int getTotal() { return 2; }            // note that the sum is 12 (but 1 more from above)
}
class F implements Element {
  public int getTotal() { return 1; }
}
class G implements Element {
  public int getTotal() { return 4; }
}
class H implements Element {
  public int getTotal() { return 2; }
}
class I implements Element {
  public int getTotal() { return 3; }
}

