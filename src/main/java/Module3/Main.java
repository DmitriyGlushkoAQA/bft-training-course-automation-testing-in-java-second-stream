package Module3;

import static Module3.RecipientOfTheService.pensionAmount;

public class Main {

    public static void main(String[] args) {
        pensionAmount = 21233.45;

        RecipientOfTheService recipient = new RecipientOfTheService();
        recipient.flName = "Столяров Иван";
        recipient.workExp = 30;

        recipient.pensionInfo();
    }
}