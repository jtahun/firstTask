package creational.builder;

public class WaiterBring {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        waiter.setPizzaBuilder(new HawaiianPizzaBuilder());
        waiter.createPizza();
        Pizza hawaiian = waiter.getPizza();
        hawaiian.showPizza();

        waiter.setPizzaBuilder(new MeatPizzaBuilder());
        waiter.createPizza();
        Pizza meatPizza = waiter.getPizza();
        meatPizza.showPizza();

    }
}
