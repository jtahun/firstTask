package behavioral.strategy;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        vehicle.setMode(new Walking());
        vehicle.executeMode();

        vehicle.setMode(new Biking());
        vehicle.executeMode();

        vehicle.setMode(new Driving());
        vehicle.executeMode();

        vehicle.setMode(new Flying());
        vehicle.executeMode();
    }
}