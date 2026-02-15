package net.proselyte.gofpatterns.structural.decorator;

public class DeveloperDecorator implements Developer{
    Developer developer;

    public DeveloperDecorator(Developer developer){
        this.developer = developer;
    }

    @Override
    public String writeCode(){
        return developer.writeCode();
    }
}
