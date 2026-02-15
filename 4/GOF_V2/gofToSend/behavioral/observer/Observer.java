package net.proselyte.gofpatterns.behavioral.observer;

import java.util.List;

public interface Observer {
    public void handleEvent(List<String> vacancies);
}
