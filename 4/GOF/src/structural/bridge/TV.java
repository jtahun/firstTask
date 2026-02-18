package structural.bridge;

class TV implements Device {
    @Override
    public void turnOn() { System.out.println("Телезор включен"); }
    @Override
    public void turnOff() { System.out.println("Телезор выключен"); }
    @Override
    public void setVolume(int value) { System.out.println("Громкость TV: " + value + "%"); }
}
