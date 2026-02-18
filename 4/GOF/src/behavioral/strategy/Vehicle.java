package behavioral.strategy;

class Vehicle {
    private TransportMode mode;

    public void setMode(TransportMode mode) {
        this.mode = mode;
    }

    public void executeMode() {
        mode.move();
    }
}