package Module3;

public class Main {
    public static void main(String[] args) {
        RecipientOfTheService recipient = new RecipientOfTheService();
        recipient.flName = "Столяров Иван";
        recipient.workExp = 30;

        recipient.pensionInfo();
    }
}