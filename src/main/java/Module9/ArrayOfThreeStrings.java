package Module9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOfThreeStrings {

    private String[] strings;

    public ArrayOfThreeStrings(String[] strings) {
        this.strings = strings;
    }

    public void uppercaseOutput() {
        System.out.println("Первая строка из массива в верхнем регистре: " + strings[0].toUpperCase());
    }

    public void lowercaseOutput() {
        System.out.println("Вторая строка из массива в нижнем регистре: " + strings[1].toLowerCase());
    }

    public void newThirdString() {
        StringBuilder modifiedString = new StringBuilder(strings[2]);
        modifiedString.insert(2, "О ");
        System.out.println("Третья строка из массива, где третья буква - О, а между третьей и четвертой буквами пробел: " + modifiedString);
    }

    public void generateRandomNumber(int min, int max) {
        double a = (Math.random() * (max - min + 1) + min);
        if (a < 2) {
            System.out.printf("Случайное число в диапазоне [0;2] : %f", a);
        } else {
            System.out.printf("Случайное число в диапазоне [0;2] : %d", (int) a);
        }
    }

    public void printRandomString(String[] str) {
        List<String> list = Arrays.asList(str);
        Collections.shuffle(list);
        System.out.printf("\nСлучайная строка: %s", list.get(0));
    }
}