package behavioral.command;

class GreenCommand implements Command{
    private TrafficLight light;

    public GreenCommand(TrafficLight light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.green();
    }
}