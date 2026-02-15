package net.proselyte.gofpatterns.creational.abstractFactory.webSite;

import net.proselyte.gofpatterns.creational.abstractFactory.PM;

public class WebSitePM implements PM {
    @Override
    public void makeManage() {
        System.out.println("PM manging Site project.");
    }
}
