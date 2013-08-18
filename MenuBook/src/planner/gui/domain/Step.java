package planner.gui.domain;

/** Step class currently unused
 * 
 * @author Joel Santiago
 *
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
