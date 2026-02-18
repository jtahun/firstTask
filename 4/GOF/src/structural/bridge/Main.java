package structural.bridge;

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