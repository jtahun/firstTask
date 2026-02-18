package behavioral.command;

class RedCommand implements Command{
    private TrafficLight light;

    public RedCommand(TrafficLight light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.red();
    }
}