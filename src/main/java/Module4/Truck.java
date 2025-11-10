package Module4;

public class Truck extends Car {

    public Truck(String model, int year) {
        super(model, year);
    }

    @Override
    public void makeBeBe() {
        System.out.println("Водитель " + model + " " + year + " издает громкий звуковой сигнал, двигаясь задним ходом");
    }
}