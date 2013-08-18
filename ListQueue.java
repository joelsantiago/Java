/**
 * Created with IntelliJ IDEA.
 * User: Joel
 * Date: 6/8/13
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class ListQueue {
    /**
     * Construct the queue.
     */
    public ListQueue( ) {
        front = back = null;
    }

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return front == null;
    }

    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    public void enqueue( Object x ) {
        if( isEmpty( ) )    // Make queue of one element
            back = front = new ListNode( x );
        else                // Regular case
            back = back.next = new ListNode( x );
    }

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public Object dequeue( ) {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue dequeue" );

        Object returnValue = front.element;
        front = front.next;
        return returnValue;
    }

    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public Object getFront( ) {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue getFront" );
        return front.element;
    }

    /**
     * Make the queue logically empty.
     */
    public void makeEmpty( ) {
        front = null;
        back = null;
    }

    private ListNode front;
    private ListNode back;
}

