package creational.builder;

public class MeatPizzaBuilder implements PizzaBuilder{
    private final Pizza pizza;

    public MeatPizzaBuilder(){this.pizza = new Pizza();}

    @Override
    public void buildDough(){pizza.setDough("thick");}

    @Override
    public void buildSauce(){pizza.setSauce("barbeque");}

    @Override
    public void buildTopping(){pizza.setTopping(" beacon, pepperoni, sausage ");}

    @Override
    public Pizza getPizza(){return pizza;}
}
