package creational.builder;

public class HawaiianPizzaBuilder implements PizzaBuilder{
    private final Pizza pizza;

    public HawaiianPizzaBuilder(){this.pizza = new Pizza();}

    @Override
    public void buildDough(){pizza.setDough("thin");}

    @Override
    public void buildSauce(){pizza.setSauce("tomato sauce");}

    @Override
    public void buildTopping(){pizza.setTopping("becon and pineaple.");}

    @Override
    public Pizza getPizza(){return pizza;}
}
