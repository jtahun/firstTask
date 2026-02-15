package net.proselyte.gofpatterns.creational.builder;

public class EnterPriceWebSiteBuilder extends WebSiteBuilder{
    @Override
    void buildName() {
        webSite.setName("EnterPrise web site");
    }

    @Override
    void buildCsm() {
        webSite.setCms(Cms.TWO);
    }

    @Override
    void buildPrice() {
        webSite.setPrice(700);
    }
}
