package net.proselyte.gofpatterns.behavioral.observer;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("First Java position");
        jobSite.addVacancy("Second Java position");

        Observer firstSubscriber = new Subscriber("Eugene Suleimanov");
        Observer secondSubscriber = new Subscriber("Max Plank");

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy("Third Java position");

        jobSite.removeVacancy("First Java position");

    }
}
