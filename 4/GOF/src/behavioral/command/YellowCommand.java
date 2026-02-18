package behavioral.command;

class YellowCommand implements Command{
    private TrafficLight light;

    public YellowCommand(TrafficLight light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.yellow();
    }
}
