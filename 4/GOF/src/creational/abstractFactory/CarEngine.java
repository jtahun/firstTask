package creational.abstractFactory;

class CarEngine implements Engine{
    @Override
    public void engineDesc(){
        System.out.println("Car Engine sound like RRRR-RRRR-RRRR");
    }
}
