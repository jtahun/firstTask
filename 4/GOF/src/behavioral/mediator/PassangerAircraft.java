package behavioral.mediator;

class PassengerAircraft implements Aircraft{
    private final String name;
    private final ControlMediator mediator;

    public PassengerAircraft(String name, ControlMediator mediator){
        this.mediator = mediator;
        this.name = name;
    }

    public String getName(){ return name;}

    @Override
    public void sendMessage(String msg){
        System.out.println("civil " + name + " peredayot: " + msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receiveMessage(String msg){
        System.out.println("civil " + name + " prinimayet: " + msg);
    }
}