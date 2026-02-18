package structural.bridge;

class Radio implements Device {
    @Override
    public void turnOn() { System.out.println("Rадио включено"); }
    @Override
    public void turnOff() { System.out.println("Радио выключено"); }
    @Override
    public void setVolume(int value) { System.out.println("Громкость  радио: " + value + "%"); }
}
