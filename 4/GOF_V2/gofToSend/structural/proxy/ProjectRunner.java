package net.proselyte.gofpatterns.structural.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project =  new ProxyProject("https://wwww.github.com/pro/typeOne");
        project.run();
    }
}
