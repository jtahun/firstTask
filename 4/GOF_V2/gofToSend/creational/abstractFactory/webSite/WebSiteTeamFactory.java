package net.proselyte.gofpatterns.creational.abstractFactory.webSite;

import net.proselyte.gofpatterns.creational.abstractFactory.Developer;
import net.proselyte.gofpatterns.creational.abstractFactory.PM;
import net.proselyte.gofpatterns.creational.abstractFactory.ProjectTeamFactory;
import net.proselyte.gofpatterns.creational.abstractFactory.Tester;

public class WebSiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public PM getManager() {
        return new WebSitePM();
    }
}
