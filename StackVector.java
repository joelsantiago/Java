import java.util.*;

class EmptyException extends Exception {
	public EmptyException (String s) {super (s);}
}

class FullException extends Exception {
	public FullException (String s) {super (s);}
}


public class StackVector {

	Vector v;

   public StackVector() {
   	v = new Vector();
   }

   public void push(Object o) throws FullException {
   	if (!isFull()) {
  			v.addElement(o);
   	} else throw new FullException ("This stack is full");
	}

   public Object pop() throws EmptyException {
    	Object o;

		if (!isEmpty()) {
    		o = (Object)v.elementAt(v.size() - 1);
			v.removeElementAt(v.size() - 1);
			return o;
		} else if (isEmpty()) {
			throw new EmptyException ("This stack is empty");
    	} else return null;
   }

   public boolean isEmpty() {
   	return v.isEmpty();
   }

  	public boolean isFull() {
    	return v.size() == v.capacity();
   }

   public static void main(String[] args) {
    	try {
  			StackVector s = new StackVector();

  			s.push(new Person("Name 1", 10));
      	s.push(new Person("Name 2", 20));
      	s.push(new Person("Name 3", 30));

  			while (!s.isEmpty()) {
  				System.out.println(s.pop());
  			}
		} catch (FullException e) {
			System.out.println("FullException: " + e.getMessage());
		} catch (EmptyException e) {
			System.out.println("EmptyException: " + e.getMessage());
		}
	}
}

/* Output

Name 3  30
Name 2  20
Name 1  10

*/

