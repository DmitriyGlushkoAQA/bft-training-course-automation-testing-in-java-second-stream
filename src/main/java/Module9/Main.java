package Module9;

public class Main {

    /**
     * • Добавить классу, в котором создан массив из трех строк генерацию случайного числа от 0 до 2.
     * • Написать метод, который случайным образом выводит в консоль одну из
     * трех строк.
     */

    public static void main(String[] args) {
        String[] strings = {"привет", "ПОКА", "гипербола"};

        ArrayOfThreeStrings array = new ArrayOfThreeStrings(strings);

        array.uppercaseOutput();
        array.lowercaseOutput();
        array.newThirdString();
        array.generateRandomNumber(0, 2);
        array.printRandomString(strings);
    }
}