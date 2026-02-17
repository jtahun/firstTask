public class Main{
    public static void main(String[] args){
        Director director = new Director();
        director.setBuilder(new EnterpriseWebsiteBuilder());
        WebSite wb = director.buildWebsite();
        
        System.out.println(wb);
        
        director.setBuilder(new VisitCardSeBuilder());
        wb = director.buildWebsite();
        
        System.out.println(wb);
     
    }
}

enum Cms{
    WORDPRESS, ALIFRESCO;
}

class WebSite{
    private String name;
    private Cms cms;
    private int price;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCms(Cms cms){
        this.cms = cms;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "\nWebSite {name= "+name+"; cms= "+ cms +"; price= "+price+"; }";
    }
}

abstract class WebSiteBuilder{
    WebSite website;
    
    void createWebsite(){
        website = new WebSite();
    }
    
    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();
    
    WebSite getWebsite(){
        return website;
    }
}

class Director{
    WebSiteBuilder wbBuilder;
    
    public void setBuilder(WebSiteBuilder wbBuilder){ this.wbBuilder = wbBuilder;}
    
    WebSite buildWebsite(){
        wbBuilder.createWebsite();
        wbBuilder.buildName();
        wbBuilder.buildCms();
        wbBuilder.buildPrice();
        
        WebSite website = wbBuilder.getWebsite();
        return website;
    }
}

class EnterpriseWebsiteBuilder extends WebSiteBuilder{
    @Override
    public void buildName(){website.setName("Enterprice website lux");}
    
    @Override
    public void buildCms(){website.setCms(Cms.ALIFRESCO);}
    
    @Override 
    public void buildPrice(){website.setPrice(10000);}
}


class VisitCardSeBuilder extends WebSiteBuilder{
    @Override
    public void buildName(){website.setName("VisitCard website next");}
    
    @Override
    public void buildCms(){website.setCms(Cms.WORDPRESS);}
    
    @Override 
    public void buildPrice(){website.setPrice(5000);}
}