package structural.composite;

class CarTransport implements Transport{
    @Override
    public void delivery(){
        System.out.println("Car delivery service.");
    }
}