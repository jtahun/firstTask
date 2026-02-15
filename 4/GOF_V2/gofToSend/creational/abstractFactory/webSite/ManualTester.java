package net.proselyte.gofpatterns.creational.abstractFactory.webSite;

import net.proselyte.gofpatterns.creational.abstractFactory.Tester;

public class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Tester do manual tests.");
    }
}
