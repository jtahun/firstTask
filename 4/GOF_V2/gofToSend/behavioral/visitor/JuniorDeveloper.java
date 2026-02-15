package net.proselyte.gofpatterns.behavioral.visitor;

public class JuniorDeveloper  implements Developer{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Class writed by junior");
    }

    @Override
    public void create(Database database) {
        System.out.println("Drop database");
    }

    @Override
    public void create(Test test) {
        System.out.println("Test writed by junior");
    }
}
