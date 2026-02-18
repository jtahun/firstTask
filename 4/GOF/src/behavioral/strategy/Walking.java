package behavioral.strategy;

class Walking implements TransportMode {
    public void move() { System.out.println("Иду пешком (скорость 5 км/ч)"); }
}