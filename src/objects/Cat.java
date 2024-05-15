package objects;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }
    public boolean eat(Plate plate) {
        if (plate.getFoodAmount() > this.appetite) {
            System.out.println(name + " поживился");
            plate.decreaseFood(appetite);
            this.fullness = true;
            return true;
        } else {
            System.out.println(name + " не смог поживиться");
            return false;

        }
    }
    public boolean isFullness() {
        return fullness;
    }
    public String getName() {
        return name;
    }
}
