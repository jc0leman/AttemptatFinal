public class Food {
    private String name;
    private int calories;

    private int servingSize;
    //just used for getter and setter methods - all the foods from the csv are a part of this class
    //used in the user and the calorietracker methods
    public Food(String name, int servingSize, int calories) {
        this.name = name;
        this.servingSize = servingSize;
        this.calories = calories;
    }


    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
