package Module8;

public class Main {

    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();

        guitar.play(NumberOfStringData.Enum.guitarStrings);
        piano.play(NumberOfStringData.Enum.pianoStrings);
    }
}