package creational.builder;

public class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder builder){this.pizzaBuilder = builder;}

    public Pizza getPizza(){return pizzaBuilder.getPizza();}

    public void createPizza(){
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}
