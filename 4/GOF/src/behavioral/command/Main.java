package behavioral.command;

public class Main{
    public static void main(String[] args){
        TrafficLight light = new TrafficLight();

        TrafficController controller = new TrafficController(
                new RedCommand(light),
                new YellowCommand(light),
                new GreenCommand(light),
                new OffCommand(light)
        );
        controller.stop();
        controller.prepare();
        controller.go();
        controller.shutdown();
    }
}