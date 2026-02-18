package structural.bridge;

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void volumeUp();
    abstract void volumeDown();
}