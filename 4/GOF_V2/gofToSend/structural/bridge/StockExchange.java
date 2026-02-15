package net.proselyte.gofpatterns.structural.bridge;

public class StockExchange extends Program{
    protected StockExchange(Developer developer){
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Exchange Stock system is developing...");
        developer.writeCode();
    }

}
