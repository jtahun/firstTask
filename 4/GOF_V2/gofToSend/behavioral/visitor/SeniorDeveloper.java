package net.proselyte.gofpatterns.behavioral.visitor;

public class SeniorDeveloper implements Developer{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Great class by senior.");
    }

    @Override
    public void create(Database database) {
        System.out.println("highspeed database from senior");
    }

    @Override
    public void create(Test test) {
        System.out.println("Test touching all sides by senior");
    }
}
