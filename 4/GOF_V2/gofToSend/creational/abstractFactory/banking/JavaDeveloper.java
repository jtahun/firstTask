package net.proselyte.gofpatterns.creational.abstractFactory.banking;

import net.proselyte.gofpatterns.creational.abstractFactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer do banking app");
    }
}
