package net.proselyte.gofpatterns.structural.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator{
    public SeniorJavaDeveloper(Developer developer){
        super(developer);
    }

    public String makeCodeReview(){
        return "Senior Java make rewiew...";
    }

    @Override
    public String writeCode() {
        return super.writeCode() + makeCodeReview() ;
    }
}
