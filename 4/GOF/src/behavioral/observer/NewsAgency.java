package behavioral.observer;

import java.util.ArrayList;
import java.util.List;


class NewsAgency implements Derived {
    private List<String> news = new ArrayList<>();
    private List<Announcer> subscribers = new ArrayList<>();

    public void addNews(String newsItem) {
        news.add(newsItem);
        notifyObservers();
    }

    public void removeNews(String newsItem) {
        news.remove(newsItem);
        notifyObservers();
    }

    @Override
    public void addObserver(Announcer observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(Announcer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Announcer o : subscribers) {
            o.handleEvent(news);
        }
    }
}
