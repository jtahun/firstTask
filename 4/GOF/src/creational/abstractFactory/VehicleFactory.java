package creational.abstractFactory;

interface VehicleFactory{
    Engine createEngine();
    Transmission createTransmission();
    Wheels createWheels();
}