package planner.gui.domain;

import java.util.ArrayList;

abstract class FoodComposite implements FoodElement{

    private ArrayList<FoodElement> elements = new ArrayList<FoodElement>();
	
    public void add(FoodElement e) {
        elements.add(e);
    }
	
    public void remove(FoodElement e) {
	elements.remove(e);
    }
	
    @Override
    public long getCalories() {
	int total = 0;
		
	for(FoodElement e : elements)
            total += e.getCalories();
	return total;
    }
	
    @Override
    public String toString() {
	String s = "";
	for(FoodElement e : elements)
            s += e.toString();
	return s;
    }
}