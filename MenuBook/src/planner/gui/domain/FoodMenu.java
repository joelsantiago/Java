package planner.gui.domain;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/10/14
 * Time: 11:02 AM
 */
public class FoodMenu extends FoodComposite {

    public static HashMap<String, FoodMenu> hashMap = new HashMap<String, FoodMenu>();

    /** Container for the menu name */
    private String menuName;

    /** Container for the menu's three types */
    private MenuType menuType;

    /** FoodMenu constructor
     *
     * 	assigns passed values to local variables
     *
     * 	@param menuName			FoodMenus name
     * 	@param menuType			Will be either BREAKFAST, LUNCH, or DINNER
     */
    public FoodMenu(String menuName, MenuType menuType) {
        this.menuName = menuName;
        this.menuType = menuType;
        hashMap.put(this.menuName, this);
    }

    /** toString method */
    @Override
    public String toString() {
        return "\nMenu: " + menuName + " (" + menuType + ")\n" + super.toString();
    }
}
