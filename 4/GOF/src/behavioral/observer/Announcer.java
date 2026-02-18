package behavioral.observer;
import java.util.List;


interface Announcer {
    void handleEvent(List<String> news);
}
