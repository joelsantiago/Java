class EmptyException extends Exception {
	public EmptyException (String s) {super (s);}
}

class FullException extends Exception {
	public FullException (String s) {super (s);}
}


public class Stack {
    
	final private static int TOS = -1;      	  						
  	final private static int SIZE = 10;    	  						
 
 	private static int top = 0;                   					
  	private Object[] st = new Object[SIZE]; 							

   public Stack() {                          	  				
   	top = TOS;
   }
 
   public void push(Object o) throws FullException {          
   	if (!isFull()) {                         	  
    		st[++top] = o;
   	} else throw new FullException("This stack is full");
	}	
    
   public Object pop() throws EmptyException {                    	  	
    	if (!isEmpty()) {
    		return st[top--];
		} else if (isEmpty()) {
			throw new EmptyException("This stack is empty");
    	} else return null;
   }
    
   public boolean isEmpty() {                     	
   	return top == TOS;
   }

  	public boolean isFull() {                   	
    	return top == SIZE-1;
   }

   public static void main(String[] args) {
    	try {
			Stack s = new Stack();                 	  
			int i = 1;

			while (!s.isFull()) {
				s.push(new Person("Name " + i, i * 10));
				i++;						
				if (s.isFull()) {
					i++;
					s.push(new Person("Name " + i, i * 10)); 
				}
			}	
			while (!s.isEmpty()) {                   	  	
    			s.pop();
				if (s.isEmpty()) {
					s.pop();
				}
			}
		} catch (FullException e) {
			System.out.println("FullException: " + e.getMessage());
		} catch (EmptyException e) {
			System.out.println("EmptyException: " + e.getMessage());
		}
	}
}

/* Output

FullException: This stack is full
EmptyException: This stack is empty

*/

