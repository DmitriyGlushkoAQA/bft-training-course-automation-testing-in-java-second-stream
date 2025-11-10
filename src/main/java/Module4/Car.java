package Module4;

public class Car {

    String model;
    int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public void makeBeBe() {
        System.out.println("Водитель " + model + " " + year + " вежливо сигналит, пропуская другой автомобиль");
    }
}