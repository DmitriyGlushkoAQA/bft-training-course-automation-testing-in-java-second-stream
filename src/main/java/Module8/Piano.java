package Module8;

public class Piano implements Playable {

    @Override
    public void play(int countOfString) {
        System.out.printf("\nНа фортепиано исполняют музыку, используя %d струн", countOfString);
    }
}