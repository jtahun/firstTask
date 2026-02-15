package net.proselyte.gofpatterns.creational.abstractFactory.banking;

import net.proselyte.gofpatterns.creational.abstractFactory.PM;

public class BankingPM implements PM {
    @Override
    public void makeManage() {
        System.out.println("Managing banking app");
    }
}
