interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int value);
}

class TV implements Device {
    @Override
    public void turnOn() { System.out.println("Телезор включен"); }
    @Override
    public void turnOff() { System.out.println("Телезор выключен"); }
    @Override
    public void setVolume(int value) { System.out.println("Громкость TV: " + value + "%"); }
}

class Radio implements Device {
    @Override
    public void turnOn() { System.out.println("Rадио включено"); }
    @Override
    public void turnOff() { System.out.println("Радио выключено"); }
    @Override
    public void setVolume(int value) { System.out.println("Громкость  радио: " + value + "%"); }
}

abstract class RemoteControl {
    protected Device device; 
    
    public RemoteControl(Device device) {
        this.device = device;
    }
   
    abstract void volumeUp();
    abstract void volumeDown();
}

class BasicRemote extends RemoteControl {
    private int volume;
    
    public BasicRemote(Device device) {
        super(device);
    }
    
    @Override
    void volumeUp() {
        volume = (int)(Math.random()*100) + 1;
        device.setVolume(volume);
    }
    
    @Override
    void volumeDown() {
        volume = Math.max(0, volume - 10);
        device.setVolume(volume);
    }
}

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl tvRemote = new BasicRemote(tv);
        RemoteControl radioRemote = new BasicRemote(radio);
        
        System.out.println("=== Управляем TV ===");
        tvRemote.volumeUp();       
        tvRemote.volumeDown();     
           
        
        System.out.println("\n=== Управляем радио ===");
        radioRemote.volumeUp();    
        radioRemote.volumeDown();  
    }
}