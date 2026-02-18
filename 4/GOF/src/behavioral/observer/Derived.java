package behavioral.observer;

interface Derived {
    void addObserver(Announcer observer);
    void removeObserver(Announcer observer);
    void notifyObservers();
}