package net.proselyte.gofpatterns.creational.abstractFactory.banking;

import net.proselyte.gofpatterns.creational.abstractFactory.Developer;
import net.proselyte.gofpatterns.creational.abstractFactory.PM;
import net.proselyte.gofpatterns.creational.abstractFactory.ProjectTeamFactory;
import net.proselyte.gofpatterns.creational.abstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public PM getManager() {
        return new BankingPM();
    }
}
