package objects;

public class Plate {
    private int foodAmount;

    public Plate(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void decreaseFood(int amount){
        foodAmount -= amount;
        System.out.println("В тарелке осталось "+ foodAmount);
    }
    public void increaseFood(int amount){
        foodAmount += amount;
        System.out.println("В тарелке есть "+ foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
