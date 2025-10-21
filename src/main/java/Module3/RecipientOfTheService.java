package Module3;

public class RecipientOfTheService {

    public String flName; //имя получателя услуги
    public double workExp; //стаж работы

    public static double pensionAmount = 23564.46; //размер пенсии

    public double pensionCalculation(){         //расчет пенсионных надбавок
        double increasePension = 0;
        if (workExp > 25){
            increasePension = (workExp - 25) * 1000;
        }
        return pensionAmount + increasePension;
    }

    public void pensionInfo(){                  //вывод информации о ПУ
        System.out.println("Получатель услуги: " + flName + "\nСтаж работы: " + workExp + " лет");
        System.out.println("Текущий размер пенсии: " + pensionCalculation() + " руб.");
    }
}
