package behavioral.observer;


public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        agency.addNews("Breaking: Market hits record high");
        agency.addNews("Weather forecast: Sunny all week");

        Announcer subscriber1 = new Subscriber("John Doe");
        Announcer subscriber2 = new Subscriber("Jane Smith");

        agency.addObserver(subscriber1);
        agency.addObserver(subscriber2);

        agency.addNews("Sports: Local team wins championship");
        agency.removeNews("Weather forecast: Sunny all week");
    }
}
