package planner.gui;

import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import planner.gui.domain.*;

/**
 * Created with IntelliJ IDEA
 * User: joelsantiago
 * Date: 3/10/14
 * Time: 10:52 AM
 */
public class PlannerApplet extends JApplet implements ActionListener {

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField
            menuName    = new JTextField(10),
            recipeName  = new JTextField(10),
            quantityName    = new JTextField(10),
            stepName    = new JTextField(10);
    private JComboBox
            menuList    = new JComboBox(),
            recipeList  = new JComboBox(),
            itemList    = new JComboBox(),
            unitList    = new JComboBox();
    private JRadioButton
            breakfast   = new JRadioButton("Breakfast",true),
            lunch       = new JRadioButton("Lunch",true),
            dinner      = new JRadioButton("Dinner",true);

    private JTextArea ta = new JTextArea(20,60);

    private MenuBook mb = new MenuBook();

    @Override
    public void init() {
        layout = new GridBagLayout();
        setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4,2,4,2);

        addComponent(new JLabel("MENU BOOK"),0,1,1,1);

        JButton showMenuBook = new JButton("Show Book");
        addComponent(showMenuBook,0,2,1,1);

        addComponent(new JLabel("MENU"),2,1,1,1);
        addComponent(new JLabel("New Menu Name"),2,2,1,1);
        addComponent(menuName,3,2,2,1);
        addComponent(new JLabel("Menu Type"),4,2,1,1);
        ButtonGroup bg = new ButtonGroup();
        bg.add(breakfast);
        bg.add(lunch);
        bg.add(dinner);
        addComponent(breakfast,5,2,1,1);
        addComponent(lunch,5,3,1,1);
        addComponent(dinner,5,4,1,1);
        JButton addMenu = new JButton("Create Menu");
        addComponent(addMenu,3,4,1,1);

        addComponent(new JLabel("Menus"),6,2,1,1);
        addComponent(menuList,7,2,2,1);
        Iterator it1 = FoodMenu.hashMap.keySet().iterator();
        while (it1.hasNext())
            menuList.addItem(it1.next());

        JButton showMenu = new JButton("Show Menu");
        addComponent(showMenu,7,4,1,1);
        JButton removeMenu = new JButton("Remove Menu");
        addComponent(removeMenu,7,5,1,1);

        addComponent(new JLabel("RECIPE"),8,1,1,1);
        addComponent(new JLabel("New Recipe Name"),8,2,1,1);
        addComponent(recipeName,9,2,2,1);
        JButton createRecipe = new JButton("Create Recipe");
        addComponent(createRecipe,9,4,1,1);

        addComponent(new JLabel("Recipes"),10,2,1,1);
        addComponent(recipeList,11,2,2,1);
        Iterator it2 = Recipe.hashMap.keySet().iterator();
        while (it2.hasNext())
            recipeList.addItem(it2.next());

        JButton showRecipe = new JButton("Show Recipe");
        addComponent(showRecipe,11,4,1,1);
        JButton removeRecipe = new JButton("Remove Recipe");
        addComponent(removeRecipe,11,5,1,1);
        JButton addRecipe = new JButton("Add Recipe");
        addComponent(addRecipe,11,7,1,1);

        addComponent(new JLabel("INGREDIENTS"),13,1,1,1);
        addComponent(new JLabel("Items"),13,2,1,1);
        addComponent(itemList,14,2,2,1);
        itemList.addItem("Select Item");
        Iterator it3 = Item.hashMap.keySet().iterator();
        while (it3.hasNext())
            itemList.addItem(it3.next());

        addComponent(new JLabel("Units"),13,4,1,1);
        addComponent(unitList,14,4,1,1);
        unitList.addItem("Select Unit");
        Iterator it4 = Unit.hashMap.keySet().iterator();
        while (it4.hasNext())
            unitList.addItem(it4.next());

        addComponent(new JLabel("Quantity"),13,5,1,1);
        addComponent(quantityName,14,5,1,1);
        JButton addIngredient = new JButton("Add Ingredient");
        addComponent(addIngredient,14,7,1,1);

        addComponent(new JLabel("STEPS"),15,1,1,1);
        addComponent(new JLabel("New Step Description"),15,2,1,1);
        addComponent(stepName,16,2,2,1);
        JButton addStep = new JButton("Add Step");
        addComponent(addStep,16,4,1,1);


        // ActionListeners to watch for button presses
        showMenuBook.addActionListener(this);
        addMenu.addActionListener(this);
        showMenu.addActionListener(this);
        removeMenu.addActionListener(this);
        createRecipe.addActionListener(this);
        showRecipe.addActionListener(this);
        removeRecipe.addActionListener(this);
        addRecipe.addActionListener(this);
        addIngredient.addActionListener(this);
        addStep.addActionListener(this);

        // TECHNIQUE #1: Respond to an Event using Applet's actionPerformed()
        //showMenuBook.addActionListener(this);            // PlannerApplet "is a" ActionListener and
        // has a ActionPerformed() method below
        // "this" is the PlannerApplet itself and
        // and ActionPerformed will be "callbacked" when
        // showMenuBook Button is pushed.
        // Domain Logic, to process this event, will be
        // implemented in ActionPerformed() (Ex7d)

    /*
    //The first way to respond to a Button is the addActionListener(this) above

    //Here are two more ways of introducing Domain Logic to handle events:

    // TECHNIQUE #2: Respond to an Event using an INNER class
    // this is an inner class, specific for one type of action
    // the code would need one inner class per each possible action
    // this shows the Domain Logic and GUI as tightly "coupled"
    // the advantage to any of these approaches is that Domain Logic
    // can "see" the widgets and operate on them, e.g. "ta", the TextArea
    class MenuBookListener implements ActionListener { // knows how to respond
      public void actionPerformed(ActionEvent e) {     // must have this method
        ta.append(mb.toString());                      // append the full MenuBook to the ta
      }
    }
    MenuBookListener mbl = new MenuBookListener();     // instantiate this inner class
    showMenuBook.addActionListener(mbl);               // identify this instance as the listener for the button

    showMenuBook.addActionListener(new MenuBookListener());  // instead: just new the inner class right here
    */
        // TECHNIQUE #3: Respond to an Event using an ANONYMOUS INNER class

    /*addMenu.addActionListener (
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = (String)e.getActionCommand();
                String newMenu = menuName.getText();

                if(cmd.equals("Create Menu")) {
                    if(breakfast.isSelected())
                    {
                        menuList.insertItemAt(newMenu,1);
                        menuList.setSelectedIndex(0);
                        mb.add(new FoodMenu(newMenu, MenuType.BREAKFAST));
                        ta.append("Menu: " + newMenu + " has been added to MenuBook\n");
                    }
                    if(lunch.isSelected())
                    {
                        menuList.insertItemAt(newMenu,1);
                        menuList.setSelectedIndex(0);
                        mb.add(new FoodMenu(newMenu, MenuType.LUNCH));
                        ta.append("Menu: " + newMenu + " has been added to MenuBook\n");
                    }
                    if(dinner.isSelected())
                    {
                        menuList.insertItemAt(newMenu,1);
                        menuList.setSelectedIndex(0);
                        mb.add(new FoodMenu(newMenu, MenuType.DINNER));
                        ta.append("Menu: " + newMenu + " has been added to MenuBook\n");
                    }
                }

            }
        }
    );*/

        JPanel p = new JPanel();                           // need a JPanel for a simpler layout manager
        p.setLayout(new FlowLayout());                     // this layout manager seems to work better with TextAreas
        // this will always generate scroll bars, however, we'll let the Pane do it only if necessary
        //JScrollPane scroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scroll = new JScrollPane(ta);          // Pane will determine scrolling, give it the TextArea
        p.add(scroll);                                     // give scroll to the Panel
        p.setSize(300,300);                                // set size of Panel
        addComponent(p,17,1,8,1);                           // add panel to the grid, row 5, col 1, width 5 cells, height 1 cell
    }

    /* This is another method to print out the contents of the combo boxes while calling a function.  This was pulled and
    *  altered from menubook.java.  The only problem I couldn't figure out was how to apply the contents of the hashmap to
    *  specific comboboxes instead of just a generic one.
    */
    private void printCombo(HashMap hashMap) {
        JComboBox combo = new JComboBox();
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext())
            combo.addItem(it.next());
    }

    // helper function to add components to the grid
    private void addComponent(Component component,       // the Component to add
                              int row,                   // add Component at cell row 0..?
                              int column,                // add Component at cell column 0..?
                              int width,                 // let the Component span this many cells wide
                              int height) {              // let the Component span this many cells high
        constraints.gridx = column;                        // store the four parameters in the constraints
        constraints.gridy = row;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        layout.setConstraints(component, constraints);      // set the constraints on the layout manager
        add(component);                                     // before add the actual component to the Applet
    }

    // PlannerApplet implements ActionListener
    // Here is the required method
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = (String)e.getActionCommand();

        String newMenu = menuName.getText();
        String newRecipe = recipeName.getText();
        String newQuantity = quantityName.getText();
        String newStep = stepName.getText();

        if (cmd.equals("Show Book"))
            ta.append(mb.toString());

        if (cmd.equals("Create Menu")) {
            if (breakfast.isSelected())
            {
                menuList.insertItemAt(newMenu,0);
                menuList.setSelectedIndex(0);
                mb.add(new FoodMenu(newMenu, MenuType.BREAKFAST));
                ta.append("\nMenu: " + newMenu + " has been added to the Menu Book\n");
            }
            if (lunch.isSelected())
            {
                menuList.insertItemAt(newMenu,0);
                menuList.setSelectedIndex(0);
                mb.add(new FoodMenu(newMenu, MenuType.LUNCH));
                ta.append("\nMenu: " + newMenu + " has been added to the Menu Book\n");
            }
            if (dinner.isSelected())
            {
                menuList.insertItemAt(newMenu,0);
                menuList.setSelectedIndex(0);
                mb.add(new FoodMenu(newMenu, MenuType.DINNER));
                ta.append("\nMenu: " + newMenu + " has been added to the Menu Book\n");
            }
        }

        if (cmd.equals("Show Menu")) {
            ta.append(FoodMenu.hashMap.get(menuList.getSelectedItem().toString()).toString());
        }

        if (cmd.equals("Remove Menu")) {
            ta.append("\nMenu: " + menuList.getSelectedItem().toString() + " has been removed from the Menu Book\n");
            mb.remove(FoodMenu.hashMap.get(menuList.getSelectedItem().toString()));
            FoodMenu.hashMap.remove(menuList.getSelectedItem().toString());
            menuList.removeItem(menuList.getSelectedItem());
        }

        if (cmd.equals("Create Recipe")) {
            recipeList.insertItemAt(newRecipe,0);
            recipeList.setSelectedIndex(0);
            Recipe.hashMap.put(newRecipe, new Recipe(newRecipe));
            ta.append("\nRecipe: " + recipeList.getSelectedItem().toString() + " has been added to the Recipe List\n");
        }

        if (cmd.equals("Show Recipe")) {
            ta.append(Recipe.hashMap.get(recipeList.getSelectedItem().toString()).toString());
        }

        if (cmd.equals("Add Recipe")) {
            Recipe RecipeObj = Recipe.hashMap.get(recipeList.getSelectedItem().toString());
            FoodMenu MenuObj = FoodMenu.hashMap.get(menuList.getSelectedItem().toString());
            MenuObj.add(RecipeObj);
            ta.append("\nRecipe: " + recipeList.getSelectedItem().toString() + " has been added to the menu " + menuList.getSelectedItem().toString() + "\n");
        }

        if (cmd.equals("Remove Recipe")) {
            ta.append("\nRecipe: " + recipeList.getSelectedItem().toString() + " has been removed from menu " + menuList.getSelectedItem().toString() + "\n");
            FoodMenu slctdMenu = FoodMenu.hashMap.get(menuList.getSelectedItem().toString());
            slctdMenu.remove(Recipe.hashMap.get(recipeList.getSelectedItem().toString()));
            Recipe.hashMap.remove(recipeList.getSelectedItem().toString());
            recipeList.removeItem(recipeList.getSelectedItem().toString());
        }

        if (cmd.equals("Add Ingredient")) {
            ta.append("\n" + newQuantity + " " + unitList.getSelectedItem().toString() + " of " + itemList.getSelectedItem().toString() + " has been added to the recipe " + recipeList.getSelectedItem().toString() + "\n");
            Recipe getRecipe = Recipe.hashMap.get(recipeList.getSelectedItem().toString());
            Item getItem = Item.hashMap.get(itemList.getSelectedItem().toString());
            Unit getUnit = Unit.hashMap.get(unitList.getSelectedItem().toString());
            double qty = Double.parseDouble(newQuantity);
            Ingredient getIngredient = new Ingredient(getItem, qty, getUnit);
            getRecipe.add(getIngredient);
        }

        if (cmd.equals("Add Step")) {
            Recipe RecStep = Recipe.hashMap.get(recipeList.getSelectedItem().toString());
            Step addedStep = new Step(newStep);
            RecStep.add(addedStep);
            ta.append("\nStep: '" + addedStep + "' has been added to the recipe " + recipeList.getSelectedItem().toString() + "\n");
        }
    }
}
