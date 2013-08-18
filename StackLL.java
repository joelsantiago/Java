// Stack in Java Language

public class Stack {
    private Node first;      

    private class Node {
        private Object o;
        private Node next;
    }

    public Stack() {
        first = null;
    }

    public boolean isEmpty() {
	 return (first == null);
    }

    public void push(Object o) {
        Node prev = first;
        first = new Node();
        first.o = o;
        first.next = prev;
    }

    // delete and return the most recently added element
    public Object pop() {
        Object o = first.o;    
        first = first.next;            
        return o;                   
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(new Person("Name 1",10));
        s.push(new Person("Name 2",20));
        s.push(new Person("Name 3",30));
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

/*	Output from Stack.java - Similar to stack1.cpp
*
*	Name 3 30
*	Name 2 20
*	Name 1 10
*/
