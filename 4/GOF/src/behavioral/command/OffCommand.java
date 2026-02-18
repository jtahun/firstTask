package behavioral.command;

class OffCommand implements Command{
    private TrafficLight light;

    public OffCommand(TrafficLight light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.off();
    }
}
