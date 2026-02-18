package creational.abstractFactory;

public class Main{
    public static void main(String[] args){
        VehicleFactory[] vf = {new MotoFactory(), new CarFactory()};

        for(VehicleFactory v : vf){
            Engine engine = v.createEngine();
            Transmission transmission = v.createTransmission();
            Wheels wheels = v.createWheels();
            System.out.println("Let's see result");
            engine.engineDesc();
            transmission.transmissionDesc();
            wheels.wheelsDesc();
        }

    }
}