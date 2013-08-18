/**
 * Created with IntelliJ IDEA.
 * User: Joel
 * Date: 6/8/13
 * Time: 1:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnderflowException extends RuntimeException {
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public UnderflowException( String message ) {
        super( message );
    }
}