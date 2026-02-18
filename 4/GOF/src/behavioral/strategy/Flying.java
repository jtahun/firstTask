package behavioral.strategy;

class Flying implements TransportMode {
    public void move() { System.out.println("Лечу на самолете (скорость 900 км/ч)"); }
}
