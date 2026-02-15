package net.proselyte.gofpatterns.structural.composite;



public class Project {
    public static void main(String[] args) {
        Team team = new Team();

        Developer fJavaDeveloper = new JavaDeveloper();
        Developer sJavaDeveloper = new JavaDeveloper();
        Developer cppDeveloper = new CppDeveloper();

        team.addDeveloper(fJavaDeveloper);
        team.addDeveloper(sJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createProject();
    }
}
