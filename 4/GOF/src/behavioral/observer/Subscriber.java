package behavioral.observer;

import java.util.List;


class Subscriber implements Announcer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> news) {
        System.out.println("Dear " + name + ", latest news: " + news);
    }
}
