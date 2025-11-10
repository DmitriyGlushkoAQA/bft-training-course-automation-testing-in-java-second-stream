package Module4;

public class Main {

    public static void main(String[] args) {
        Car kia = new Car("Kia Cerato", 2014);
        Car toyota = new Car("Toyota Corolla", 2006);
        Truck truck = new Truck("Volvo", 2016);

        kia.makeBeBe();
        toyota.makeBeBe();
        truck.makeBeBe();
    }
}