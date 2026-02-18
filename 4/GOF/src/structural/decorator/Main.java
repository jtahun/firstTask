package structural.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " = $" + coffee.getCost());

        Coffee specialCoffee =   new SugarDecorator(
                new MilkDecorator(
                        new SimpleCoffee()));
        System.out.println("\nСпециальный кофе: " +
                specialCoffee.getDescription() +
                " = $" + specialCoffee.getCost());
    }
}