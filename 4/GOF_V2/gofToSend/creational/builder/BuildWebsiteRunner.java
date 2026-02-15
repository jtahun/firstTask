package net.proselyte.gofpatterns.creational.builder;

public class BuildWebsiteRunner {
    public static void main(String[] args) {
        Director director = new Director();
        WebSite webSite;

        director.setBuilder(new VisitCardWebsiteBuilder());
        webSite = director.buildWebsite();
        System.out.println(webSite);

        director.setBuilder(new EnterPriceWebSiteBuilder());
        webSite = director.buildWebsite();
        System.out.println(webSite);
    }
}
