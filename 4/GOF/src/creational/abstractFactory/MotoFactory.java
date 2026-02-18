package creational.abstractFactory;

class MotoFactory implements VehicleFactory{
    @Override
    public Engine createEngine(){return new MotoEngine();}

    @Override
    public Transmission createTransmission(){return new MotoTransmission();}

    @Override
    public Wheels createWheels(){return new MotoWheels();}
}