package creational.abstractFactory;

class CarFactory implements VehicleFactory{
    @Override
    public Engine createEngine(){return new CarEngine();}

    @Override
    public Transmission createTransmission(){return new CarTransmission();}

    @Override
    public Wheels createWheels (){return new CarWheels();}
}
