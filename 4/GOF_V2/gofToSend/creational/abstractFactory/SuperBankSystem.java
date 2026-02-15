package net.proselyte.gofpatterns.creational.abstractFactory;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import net.proselyte.gofpatterns.creational.abstractFactory.banking.BankingPM;
import net.proselyte.gofpatterns.creational.abstractFactory.banking.BankingTeamFactory;
import net.proselyte.gofpatterns.creational.abstractFactory.banking.QATester;

public class SuperBankSystem {
    public static void main(String[] args) {
        ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        PM pm = projectTeamFactory.getManager();

        System.out.println("Creating project...");
        developer.writeCode();
        tester.testCode();
        pm.makeManage();
    }
}
