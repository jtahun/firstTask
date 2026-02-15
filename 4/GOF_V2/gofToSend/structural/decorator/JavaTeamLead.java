package net.proselyte.gofpatterns.structural.decorator;

public class JavaTeamLead extends DeveloperDecorator{
    public JavaTeamLead(Developer developer){
        super(developer);
    }

    public String sendWeekReport(){
        return "Send week report to customer...";
    }

    @Override
    public String writeCode() {
        return super.writeCode() + sendWeekReport();
    }
}
