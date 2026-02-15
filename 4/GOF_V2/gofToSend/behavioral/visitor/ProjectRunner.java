package net.proselyte.gofpatterns.behavioral.visitor;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        Developer junior = new JuniorDeveloper();
        Developer senior = new SeniorDeveloper();

        System.out.println("Junior Developer does his job.");
        project.beWritten(junior);

        System.out.println("===========================================");
        System.out.println("Senior Developer does his job.");
        project.beWritten(senior);
    }
}
