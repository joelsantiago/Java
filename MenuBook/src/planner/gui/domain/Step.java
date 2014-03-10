package planner.gui.domain;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/10/14
 * Time: 11:05 AM
 */
public class Step {

    /** Container for Step text */
    private String text;

    /** Step constructor
     *
     * 	assigns passed value to local variable
     *
     * 	@param text				Step text
     */
    public Step(String text) {
        this.text = text;
    }

    /** toString method */
    @Override
    public String toString() {
        return text;
    }
}
