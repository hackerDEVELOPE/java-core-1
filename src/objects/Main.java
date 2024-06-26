package objects;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cat = {
                new Cat("Kotik", 25),
                new Cat("Botik", 5),
                new Cat("Motik", 15),
                new Cat("Dotik", 10),
                new Cat("Lotik", 30),
                new Cat("Tobik", 35)
        };
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].eat(plate)) continue;
            else {
                System.out.println("Нейросеть ПРК добавляет корма");
                plate.increaseFood(50);
                i--;
            }
        }
        System.out.println();
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isFullness()){
                System.out.println(cat[i].getName() + " хорошо поживился");
            }
            else System.out.println(cat[i].getName() + " ужасно поживился");
        }


    }
}
