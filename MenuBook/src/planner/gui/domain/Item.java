package planner.gui.domain;

import java.util.HashMap;

/** Item class 
 * 
 * 	exemplifies one food item with a specific name, base unit value and base calorie value
 * 
 * 	@author Joel Santiago
 * 
 */
public class Item implements FoodElement {
	
	public static HashMap<String, Item> hashMap = new HashMap<String, Item>();

	/** Container for the food item's name */
	private String itemName;
	
	/** Container for the Unit's name and factor value */
	private Unit baseUnit;
	
	/** Container for the food item's base calorie value */
	private long baseCalories;
	
	/** Item constructor 
	 * 
	 * 	assigns passed values to local variables
	 * 
	 * 	@param itemName			Food's name
	 * 	@param baseUnit			Food's unit name and factor value
	 * 	@param baseCalories		Food's base calories value
	 */
	public Item(String itemName, Unit baseUnit, long baseCalories) {
            this.itemName = itemName;
            this.baseUnit = baseUnit;
            this.baseCalories = baseCalories;
            hashMap.put(this.itemName, this);
	}
	
	/**	getName method 
	 * 
	 * 	gets value of local variable itemName
	 * 
	 * 	@return	returns itemName
	 */
	public String getName() {
            return itemName;
	}
	
	/**	getUnit method 
	 * 
	 * 	gets value of local variable baseUnit
	 * 
	 * 	@return	returns baseUnit
	 */
	public Unit getUnit() {
            return baseUnit;
	}
	
	/** Gets local variable baseCalories
	 * 
	 * 	@return	returns baseCalories
	 */
        @Override
	public long getCalories() {
            return baseCalories;
	}
}
