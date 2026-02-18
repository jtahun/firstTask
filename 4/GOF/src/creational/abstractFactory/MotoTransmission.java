package creational.abstractFactory;

class MotoTransmission implements Transmission{
    @Override
    public void transmissionDesc(){
        System.out.println("Transmission of Moto switched by rod.");
    }
}
