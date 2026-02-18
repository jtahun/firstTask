package behavioral.strategy;

class Driving implements TransportMode {
    public void move() { System.out.println("Еду на машине (скорость 60 км/ч)"); }
}