package net.proselyte.gofpatterns.creational.abstractFactory.banking;

import net.proselyte.gofpatterns.creational.abstractFactory.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QA tests banking app.");
    }
}
