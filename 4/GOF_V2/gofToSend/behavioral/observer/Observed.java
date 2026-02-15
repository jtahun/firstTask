package net.proselyte.gofpatterns.behavioral.observer;

public interface Observed {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    void notifyObservers();
}
