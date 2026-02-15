package net.proselyte.gofpatterns.structural.bridge;

public class JavaDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("Java developer do job");
    }
}
