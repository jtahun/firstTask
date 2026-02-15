package net.proselyte.gofpatterns.behavioral.chain;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimplyReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK.",Priority.ROUTINE);
        reportNotifier.notifyManager("Something went out of way.",Priority.IMPORTANT);
        reportNotifier.notifyManager("Huston we've got a problem.",Priority.ASAP);
    }

}
