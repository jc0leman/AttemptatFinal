//Jackson Coleman Final Project for Mr. Blick CS2
//"Stretch" goal was to have serving sizes, remanance from this goal can be seen
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CalorieTracker {
    private User user;
    private ArrayList<Food> foods;

    public CalorieTracker() {
        //injtializes arraylist of foods
        foods = new ArrayList<>();
    }

    //Alloes the code to compile throwing the file not found - we later will check to find the file in the method
    public static void main(String[] args) throws FileNotFoundException {
        //sets the arraylist to null
        ArrayList<Food> foods = null;
        User user = new User("tester");
        try {
            //tries to run the initialize method
            foods = user.initialize();
        } //if error with input/output of expression breaks
        catch (IOException e) {
            e.printStackTrace();
        }

        //sets the calorie tracker to the current instance and the user and foods
        CalorieTracker calorieTracker = new CalorieTracker();
        calorieTracker.setUser(user);
        calorieTracker.setFoods(foods);
        //calls the front end
        FrontEnd frontEnd = new FrontEnd(foods, calorieTracker);
        frontEnd.setVisible(true);
    }

    //getter setter methods
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    //search food by name through the foods arraylist (list of the foods that are in the csv
    public boolean searchFoodByName(String name) {
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.println("Match found: " + food.getName());
                return true;
            }
        }
        return false;
    }
    //same thing, except this time if a match is found the number of calories are given to the front
    public int getCaloriesByName(String name) {
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food.getCalories();
            }
        }
        return 0; // Return 0 if the food is not found
    }

}

