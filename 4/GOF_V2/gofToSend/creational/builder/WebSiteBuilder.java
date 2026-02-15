package net.proselyte.gofpatterns.creational.builder;

public abstract class WebSiteBuilder {
    WebSite webSite;

    void createWebSite(){
        webSite = new WebSite();

    }

    abstract void buildName();
    abstract void buildCsm();
    abstract void buildPrice();

    WebSite getWebSite(){
        return webSite;
    }
}
