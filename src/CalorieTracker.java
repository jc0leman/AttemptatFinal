import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CalorieTracker {
    private User user;
    private ArrayList<Food> foods;

    public CalorieTracker() {
        foods = new ArrayList<>();
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Food> foods = null;

        User user = new User("tester");
        try {
            foods = user.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CalorieTracker calorieTracker = new CalorieTracker();
        calorieTracker.setUser(user);
        calorieTracker.setFoods(foods);

        FrontEnd frontEnd = new FrontEnd(foods, calorieTracker);
        frontEnd.setVisible(true);
    }

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

    public boolean searchFoodByName(String name) {
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                System.out.println("Match found: " + food.getName());
                return true;
            }
        }
        return false;
    }
    public int getCaloriesByName(String name) {
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food.getCalories();
            }
        }
        return 0; // Return 0 if the food is not found
    }

}

