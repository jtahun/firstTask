package structural.bridge;

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