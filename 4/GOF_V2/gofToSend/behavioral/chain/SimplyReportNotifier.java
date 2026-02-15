package net.proselyte.gofpatterns.behavioral.chain;

public class SimplyReportNotifier extends Notifier{
    public SimplyReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report " + message);
    }
}
