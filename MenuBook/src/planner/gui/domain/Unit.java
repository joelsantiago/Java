package Planner.gui.domain;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/10/14
 * Time: 11:05 AM
 */
public class Unit {

    public static HashMap<String, Unit> hashMap = new HashMap<String, Unit>();

    /** Container for the unit name */
    private String unitName;

    /** Container for the unit factor value */
    private double factor;

    /** Unit constructor
     *
     * 	assigns passed values to local variables
     *
     * 	@param unitName			Unit's name
     * 	@param factor			Unit's factor value
     */
    public Unit(String unitName, double factor) {
        this.unitName = unitName;
        this.factor = factor;
        hashMap.put(this.unitName, this);
    }

    /**	getName method
     *
     * 	gets value of local variable unitName
     *
     * 	@return	returns unitName
     */
    public String getName(){
        return unitName;
    }

    /**	getFaction method
     *
     * 	gets value of local variable factor
     *
     * 	@return	returns factor
     */
    public double getFactor(){
        return factor;
    }
}
