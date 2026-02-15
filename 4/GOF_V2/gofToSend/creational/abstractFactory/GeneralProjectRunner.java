package net.proselyte.gofpatterns.creational.abstractFactory;

import net.proselyte.gofpatterns.creational.abstractFactory.banking.BankingTeamFactory;
import net.proselyte.gofpatterns.creational.abstractFactory.webSite.WebSiteTeamFactory;

public class GeneralProjectRunner {
    public static void main(String[] args) {

        ProjectTeamFactory bankingTeamFactory = new BankingTeamFactory();
        Developer developer = bankingTeamFactory.getDeveloper();
        Tester tester = bankingTeamFactory.getTester();
        PM pm = bankingTeamFactory.getManager();

        System.out.println("Creating project...");
        developer.writeCode();
        tester.testCode();
        pm.makeManage();

        ProjectTeamFactory actionTeamFactory = new WebSiteTeamFactory();
        developer = actionTeamFactory.getDeveloper();
        tester = actionTeamFactory.getTester();
        pm = actionTeamFactory.getManager();
        System.out.println("\nCreating auction website project");
        developer.writeCode();
        tester.testCode();
        pm.makeManage();


    }
}
