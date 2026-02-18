package creational.abstractFactory;

class CarTransmission implements Transmission{
    @Override
    public void transmissionDesc() {
        System.out.println("Transmission of Car switchec by pedal");
    }
}