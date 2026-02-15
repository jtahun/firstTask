package net.proselyte.gofpatterns.creational.abstractFactory;

import net.proselyte.gofpatterns.creational.abstractFactory.webSite.WebSiteTeamFactory;

public class AuctionSiteProject {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new WebSiteTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        PM pm = projectTeamFactory.getManager();

        System.out.println("Let's start....");
        developer.writeCode();
        tester.testCode();
        pm.makeManage();
    }
}
