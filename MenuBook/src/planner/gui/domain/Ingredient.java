package planner.gui.domain;

/** Ingredient class 
 * 
 * 	has an item and has a unit
 * 
 * 	@author Joel Santiago
 * 
 */
public class Ingredient implements FoodElement {
	/** Container for the items name, its factor value, and its base calories value */
	private Item item;
	
	/** Container for the items quantity value */
	private double quantity;
	
	/** Container for the units name and factor value */
	private Unit unit;
	
	/** Ingredient constructor 
	 * 
	 * 	assigns passed values to local variables
	 * 
	 * 	@param item
	 * 	@param quantity
	 * 	@param unit
	 * 
	 */
	public Ingredient(Item item, double quantity, Unit unit){
            this.item = item;
            this.quantity = quantity;
            this.unit = unit;
	}
	
	/** getCalories method
	 * 
	 * 	method gets the total amount of calories from food item using applied parameters
	 * 
	 * 	@return returns the product of the factor, the calorie per item and the quantity of the item
	 * 
	 */
        @Override
	public long getCalories() {
            return (long) ((unit.getFactor() * item.getCalories() * quantity) / item.getUnit().getFactor());
	}
	
	/**	toString method */
        @Override
	public String toString() {
            return quantity + " " + unit.getName() + " " + item.getName() + "\n";		
	}	
}
