package net.proselyte.gofpatterns.structural.decorator;

public class Task {
    public static void main(String[] args) {
        Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
        System.out.println(developer.writeCode());
    }
}
