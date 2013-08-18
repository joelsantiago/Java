// Stack in Java language                    
import java.util.*;

public class Stack {
    
    final private static int TOS = -1;      	  // constant TOS
    final private static int SIZE = 100;    	  // constant array dimension
 
    private static int top = 0;                   // current top, hidden in Stack
    private Object[] st = new Object[SIZE];	  // stack array, hidden in Stack

    public Stack() {                          	  // constructor implementation
    top = TOS;
    }
 
    public void push(Object o) {             	  // push implementation
    if (!isFull())                         	  // here is the code is similar to C
    	st[++top] = o;
    } 
    
    public Object pop() {                    	  // pop implementation
    if (!isEmpty())
    	return st[top--];
    return null;
    }
    
    public boolean isEmpty() {                    	  // isEmpty implementation
    	return top == TOS;
    }

    public boolean isFull() {                    	  // isFull implementation
    	return top == SIZE-1;
    }

    public static void main(String[] args) {
    	Stack s = new Stack();                 	  // construct a Stack
    	s.push(new Person("Name 1",10));       	  // push 3 Persons onto stack
    	s.push(new Person("Name 2",20));       	  // note: C did push(s,p) rather than spush(p)
    	s.push(new Person("Name 3",30));

    	while (!s.isEmpty())                   	  // empty the Stack
        	System.out.println(s.pop());	  // display contents
    }
}

