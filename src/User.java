import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private ArrayList<Meal> meals;

    public User(String name) {
        this.name = name;
        this.meals = new ArrayList<>();
    }

    //initalize
    //throws IOexception if there is an issue with the scanner
    //but the method should be called regardless
    public ArrayList<Food> initialize() throws IOException {
        //Sets target of the scanner to the ideal file
        Scanner input = new Scanner(new File("Resources/foods.csv"));
        input.nextLine(); // skip header line
        ArrayList<Food> foodsList = new ArrayList<Food>();
        //until it reaches the end
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] fields = line.split(",");

            String foodItem = fields[0].substring(1); //removes the first quotation mark from the list
            int servingSize = Integer.parseInt(fields[1].trim()); // use trim() to remove whitespace
            int calories = Integer.parseInt(fields[2].replaceAll("\"", "").trim()); // remove double quotes

            Food food = new Food(foodItem, servingSize, calories);
            foodsList.add(food);
        }
        input.close(); // close the scanner
        return foodsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public int calculateTotalCalories() {
        int totalCalories = 0;
        for (Meal meal : meals) {
            totalCalories += meal.getFood().getCalories() * meal.getQuantity();
        }
        return totalCalories;
    }
}
