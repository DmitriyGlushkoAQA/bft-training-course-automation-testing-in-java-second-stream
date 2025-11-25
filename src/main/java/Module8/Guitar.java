package Module8;

public class Guitar implements Playable {

    @Override
    public void play(int countOfString) {
        System.out.printf("На гитаре исполняют музыку, используя %d струн", countOfString);
    }
}