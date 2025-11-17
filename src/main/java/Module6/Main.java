package Module6;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"привет", "ПОКА", "гипербола"};

        ArrayOfThreeStrings array = new ArrayOfThreeStrings(strings);

        array.uppercaseOutput();
        array.lowercaseOutput();
        array.newThirdString();
    }
}