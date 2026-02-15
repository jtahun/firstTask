package net.proselyte.gofpatterns.creational.abstractFactory.webSite;

import net.proselyte.gofpatterns.creational.abstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println(" Php developer do job");
    }
}
