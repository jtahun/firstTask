package net.proselyte.gofpatterns.creational.builder;

public class Director {
    private WebSiteBuilder builder;

    public void setBuilder(WebSiteBuilder builder){
        this.builder = builder;
    }

    WebSite buildWebsite(){
        builder.createWebSite();
        builder.buildName();
        builder.buildCsm();
        builder.buildPrice();

        return builder.getWebSite();
    }
}
