package net.proselyte.gofpatterns.creational.abstractFactory;

public interface ProjectTeamFactory {
    Developer getDeveloper();
    Tester getTester();
    PM getManager();
}
