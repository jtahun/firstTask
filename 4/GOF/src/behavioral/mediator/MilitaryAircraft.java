package behavioral.mediator;

class MilitaryAircraft implements Aircraft{
    private final String name;
    private final ControlMediator mediator;

    public MilitaryAircraft(String name, ControlMediator mediator){
        this.name = name;
        this.mediator = mediator;
    }

    public String getName(){ return name;}

    @Override
    public void sendMessage(String msg){
        System.out.println("military " + name + " peredayot: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receiveMessage(String msg){
        System.out.println("military  " + name + " prinimayet: " + msg);
    }
}