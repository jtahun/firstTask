package net.proselyte.gofpatterns.creational.builder;

public class VisitCardWebsiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        webSite.setName("Visit card");
    }

    @Override
    void buildCsm() {
        webSite.setCms(Cms.ONE);
    }

    @Override
    void buildPrice() {
        webSite.setPrice(500);
    }
}
