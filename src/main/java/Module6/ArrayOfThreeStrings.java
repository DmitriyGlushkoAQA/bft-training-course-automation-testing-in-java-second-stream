package Module6;

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
}