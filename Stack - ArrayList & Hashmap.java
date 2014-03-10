import java.util.*;

class EmptyException extends Exception {
	public EmptyException (String s) {super (s);}
}

public class Stack {
    
	private ArrayList<Person> arrList = new ArrayList<Person>();
	private HashMap<String, Person> hMap = new HashMap<String, Person>();					

   /*
	public Stack() {                          	  				
		This wasn't being used for anything anymore, but I left it in just incase I'd need it later
   }
	*/
 
   void push(Person p) {                                   	  
  		arrList.add(p);
		hMap.put(p.getName(),p);	
  	}	
    
   public Object pop() throws EmptyException {                    	  	
    	Person p;
		int arrEnd = arrList.size() - 1;
	
		if (isEmpty()) throw new EmptyException ("This stack is empty");
		else {
			p = arrList.remove(arrEnd);
			hMap.remove(p.getName() + arrEnd);
			return p;
		}
   }
    
   boolean isEmpty() {                     	
   	return arrList.isEmpty();
   }

	public Iterator<Person> arrayIterator() {
		return arrList.iterator();
	}

	public Iterator<Person> hashIterator() {
		Collection<Person> c = hMap.values();
		return c.iterator();
	}

   public static void main(String[] args) {
    	try {
			Stack s = new Stack();
           
			s.push(new Person("Name 1", 10));
        	s.push(new Person("Name 2", 20));
        	s.push(new Person("Name 3", 30));
			
			System.out.println("Iteration of the Stack's Array");
			Iterator<Person> AL = s.arrayIterator();
         while (AL.hasNext()) {
				System.out.println(AL.next());
			}
	
			System.out.println("Iteration of the Stack's Hash");
         Iterator<Person> HM = s.hashIterator();
			while (HM.hasNext()) {
				System.out.println(HM.next());
			}


			System.out.println("Pop the Stack");
			while (!s.isEmpty()) {                   	  	
				System.out.println(s.pop());
			}
		} catch (EmptyException e) {
			System.out.println("EmptyException: " + e.getMessage());
		}
	}
}

/* Output from Stack.java

Iteration of the Stack's Array
Name 1  10
Name 2  20
Name 3  30
Iteration of the Stack's Hash
Name 2  20
Name 1  10
Name 3  30
Pop the Stack
Name 3  30
Name 2  20
Name 1  10

*/
