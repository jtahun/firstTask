package net.proselyte.gofpatterns.behavioral.memento;

public class SaveProjectRunner {
    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GitHubRepo gitHub = new GitHubRepo();

        System.out.println("Creating new project. Version 1.0");
        project.setVersionAndDate("Version 1.0");
        System.out.println(project);
        System.out.println("Saving current version to git hub");
        gitHub.setSave(project.save());

        System.out.println("Updating project to Version 1.1");
        System.out.println("Writing poor code...");
        Thread.sleep(5000);
        project.setVersionAndDate("Version 1.1");
        System.out.println(project);

        System.out.println("see a bad things...");
        System.out.println("Rolling back to Version 1.0");
        project.load(gitHub.getSave());

        System.out.println("After rollback...");
        System.out.println(project);
    }
}
