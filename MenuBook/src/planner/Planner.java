package planner;

import javax.swing.*;
import planner.gui.*;

/**
 * @author Edward Billard
 *
 * This runs PlannerApplet as an application, instead of from an html file
 *
 */
public class Planner { 
  public static void main(String args[]) {
    JApplet applet = new PlannerApplet();                  // create the applet
    JFrame frame = new JFrame("Menu Planner");             // create a frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // frame closes File->Exit
    frame.getContentPane().add(applet);                    // add applet to fram
    frame.setSize(750,900);                                // make it large enough
    applet.init();                                         // similar to constructor
    applet.start();                                        // run the applet
    frame.setVisible(true);                                // make it visible
  }
}

/*  OUTPUT AFTER EX.7D IMPLEMENTAION WITH VALIDATION CHECK AT END

Menu: M1 has been added to the Menu Book

Menu: M2 has been added to the Menu Book

Menu: M2 has been removed from the Menu Book

Recipe: R1 has been added to the Recipe List

Recipe: R2 has been added to the Recipe List

Recipe: R1 has been added to the menu M1

Recipe: R2 has been added to the menu M1

Recipe: R2 has been removed from menu M1

Step: 'S1' has been added to the recipe R1

4 slice of American Cheese has been added to the recipe R1

Recipe: R1
Ingredients:
4.0 slice American Cheese

Steps:
1. S1

Menu: M1 (LUNCH)

Recipe: R1
Ingredients:
4.0 slice American Cheese

Steps:
1. S1

Menu Book: 
Menu: Birthday Dinner (DINNER)

Recipe: Hamburgers
Ingredients:
0.25 lb Hamburger Meat
1.0 regular Hamburger Bun
1.0 slice American Cheese

Steps:
1. Grill hamburger meat for 10 minutes
2. After 5 minutes, place on cheese on hamburger
3. After 7 minutes, place top/bottom of bun on grill
4. When done, serve hamburger in bun

Menu: M1 (LUNCH)

Recipe: R1
Ingredients:
4.0 slice American Cheese

Steps:
1. S1

Total Calories: 1150

 */

// Calorie check
// Pre validation test: 
//      Total Calories: 950
//
// Post validation test:
//      Total Calories: 1150
// 
// Ingredients added:
//      4 slices of American cheese
//          Calories per slice: 50
//          Slices used: 4
//          Total Calories for 4 slices of American Cheese: 200
//
// Total Calories:
//      Before Test: 950
//      After Test: 950 + 200 = 1150

