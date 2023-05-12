public class Food {
    private String name;
    private int calories;

    private int servingSize;

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
