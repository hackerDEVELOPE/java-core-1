package practice3;
//Создать классы Собака и Кот с наследованием от класса Животное.
//Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//Добавить подсчет созданных котов, собак и животных.
public abstract class Animal {
    protected int runDistance;
    protected int swimDistance;
    protected String name;
    protected static int animalCounter = 0;
    public void run(int dist) {
        System.out.println(name + " пробежал " + dist + " м.");
    }
    public void swim(int dist){
        System.out.println(name + " проплыл " + dist + " м.");
    }
    public Animal(int runDistance, int swimDistance, String name) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.name = name;
        System.out.println("Всего живности: "+ ++animalCounter);;

    }
}
