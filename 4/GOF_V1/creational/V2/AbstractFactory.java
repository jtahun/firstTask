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



interface Engine{
    void engineDesc();
}

interface Transmission{
    void transmissionDesc();
}

interface Wheels{
    void wheelsDesc();
}

interface VehicleFactory{
    Engine createEngine();
    Transmission createTransmission();
    Wheels createWheels();
}

class MotoEngine implements Engine{
    @Override
    public void engineDesc(){
        System.out.println("Moto Engine sound like Zin-zin-zin.");
    }
}

class MotoTransmission implements Transmission{
    @Override
    public void transmissionDesc(){
        System.out.println("Transmission of Moto switched by rod.");
    }
}

class MotoWheels implements Wheels{
    @Override
    public void wheelsDesc(){
        System.out.println("Moto vehicle has 2 wheels");
    }
}

class CarEngine implements Engine{
    @Override
    public void engineDesc(){
        System.out.println("Car Engine sound like RRRR-RRRR-RRRR");
    }
}

class CarTransmission implements Transmission{
    @Override
    public void transmissionDesc() {
        System.out.println("Transmission of Car switchec by pedal");
    }
}

class CarWheels implements Wheels{
    @Override
    public void wheelsDesc(){
        System.out.println("Car vehicle has 4 wheels");
    }
}

class MotoFactory implements VehicleFactory{
    @Override
    public Engine createEngine(){return new MotoEngine();}
    
    @Override
    public Transmission createTransmission(){return new MotoTransmission();}
    
    @Override
    public Wheels createWheels(){return new MotoWheels();}
}

class CarFactory implements VehicleFactory{
    @Override
    public Engine createEngine(){return new CarEngine();}
    
    @Override
    public Transmission createTransmission(){return new CarTransmission();}
    
    @Override
    public Wheels createWheels (){return new CarWheels();}
}
