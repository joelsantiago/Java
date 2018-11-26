package Planner.gui.domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/10/14
 * Time: 11:04 AM
 */
public class Recipe extends FoodComposite {

    public static HashMap<String, Recipe> hashMap = new HashMap<String, Recipe>();

    /** Container for the recipe name */
    private String recipeName;

    /** Container for recipe's directions */
    private ArrayList<Step> steps = new ArrayList<Step>();

    /** Recipe constructor
     *
     * 	assigns passed value to local variable
     *
     * 	@param recipeName			Recipe's specific name
     */
    public Recipe(String recipeName) {
        this.recipeName = recipeName;
        hashMap.put(this.recipeName, this);
    }

    /** toString method */
    @Override
    public String toString() {
        int i = 1;
        String s = "";
        for (Step e : steps){
            s += i + ". " + e.toString() + "\n";
            i++;
        }
        //return ( "\nRecipe: " + recipeName + "\nIngredients: " + super.toString() + "\nSteps: " );
        return "\nRecipe: " + recipeName + "\nIngredients:\n" + super.toString() + "\nSteps:\n" + s;
    }

    /**
     * Adds passed value to Step array
     * @param s Step being added to array list
     */
    public void add(Step s) {
        steps.add(s);
    }

    /**
     * Removes passed value from Step array
     * @param s Step being removed from array list
     */
    public void remove(Step s) {
        steps.remove(s);
    }
}
