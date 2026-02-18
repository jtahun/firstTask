package creational.abstractFactory;

class CarWheels implements Wheels{
    @Override
    public void wheelsDesc(){
        System.out.println("Car vehicle has 4 wheels");
    }
}