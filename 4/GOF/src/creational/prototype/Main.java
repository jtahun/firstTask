package creational.prototype;

public class Main{
    public static void main(String[] args) {
        Car car = new Car("Toyota","Silver");
        System.out.println(car);

        CarFactory cf = new CarFactory(car);
        Car carClone = cf.cloneCar();
        System.out.println("=".repeat(40));
        System.out.println(carClone);
    }

}
