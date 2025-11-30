package Module14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10, 10, 10));
        boxes.add(new Box(20, 20, 20));
        boxes.add(new Box(35, 35, 35));
        boxes.add(new Box(40, 40, 40));

        List<Box> boxesWiderThan30Cm = new ArrayList<>();

        System.out.println("===Первоначальная коллекция===");
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println();

        Iterator<Box> iterator = boxes.iterator();
        while (iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getWidth() > 30) {
                boxesWiderThan30Cm.add(box);
                iterator.remove();
            }
        }

        System.out.println("===Коллекция после перебора(ширина <= 30)===");
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println();

        System.out.println("===Коллекция после перебора(ширина > 30)===");
        for (Box box : boxesWiderThan30Cm) {
            System.out.println(box);
        }
    }
}