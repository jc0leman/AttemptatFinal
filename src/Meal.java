public class Meal {
    private Food foodItem;
    private int numServings;
    private int numCalories;


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
