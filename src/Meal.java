public class Meal {
    private Food foodItem;
    private int numServings;
    private int numCalories;


    //Meal class is designed to manage the foods effectively adding another level of abstraction
    //it contains getter and setter methods
    public Meal(Food foodItem, int numServings) {
        this.foodItem = foodItem;
        this.numServings = numServings;
        this.numCalories = 0;
    }

    public Food getFood() {
        return foodItem;
    }

    public int getQuantity() {
        return numServings;
    }


    public int getTotalCalories() {
        return foodItem.getCalories() * numServings;
    }
}
