package structural.decorator;

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decorCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decorCoffee = coffee;
    }

    @Override
    public double getCost() {
        return decorCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decorCoffee.getDescription();
    }
}