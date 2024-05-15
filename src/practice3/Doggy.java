package practice3;

public class Doggy extends Animal {
    protected static int doggyCounter = 0;
    public Doggy(int runDistance, int swimDistance, String name) {
        super(runDistance, swimDistance, name);
        System.out.println("Тобиков создано: " + ++doggyCounter);
    }
    @Override
    public void run(int dist) {
        if (dist < 500) {
            super.run(dist);
        }
        else System.out.println(name + " не смог пробежать " + dist + " м.");
    }
    @Override
    public void swim(int dist) {
        if (dist < 10) {
            super.swim(dist);
        }
        else System.out.println(name + " не смог проплыть " + dist + " м.");
    }
}
