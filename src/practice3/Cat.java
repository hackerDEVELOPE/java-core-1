package practice3;

public class Cat extends Animal{
    protected static int catCounter = 0;

    public Cat(int runDistance, int swimDistance, String name) {
        super(runDistance, swimDistance, name);
        System.out.println("Папичей создано: " + ++catCounter);
    }

    @Override
    public void run(int dist) {
        if (dist < 200) {
            super.run(dist);
        }
        else System.out.println(name + " не смог пробежать " + dist + " м.");
    }

    @Override
    public void swim(int dist) {
       System.out.println(name + " не умеет плавать.");
    }
}
