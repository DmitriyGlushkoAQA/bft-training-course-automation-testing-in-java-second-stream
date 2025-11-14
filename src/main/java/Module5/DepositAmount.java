package Module5;

import java.util.Scanner;

public class DepositAmount {

    public void depositCalculationFor() {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        float deposit = input.nextFloat();
        System.out.println("Введите количество месяцев:");
        int months = input.nextInt();

        for (int i = 0; i < months; i++) {
            deposit += deposit * 0.07f;
        }

        System.out.printf("Конечная сумма вклада через %d месяцев(используя цикл for): %.2f рублей(-ля)", months, deposit);
    }

    public void depositCalculationWhile() {
        int i = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nВведите сумму вклада в рублях:");
        float deposit = input.nextFloat();
        System.out.println("Введите количество месяцев:");
        int months = input.nextInt();

        while (i < months) {
            deposit += deposit * 0.07f;
            i++;
        }

        System.out.printf("Конечная сумма вклада через %d месяцев(используя цикл while): %.2f рублей(-ля)", months, deposit);
    }
}