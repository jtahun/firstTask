interface Coffee {
    double getCost();
    String getDescription();
}

class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0; 
    }
    
    @Override
    public String getDescription() {
        return "Обычный кофе ";
    }
}

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

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 0.5; 
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + молоко";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 0.2; 
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + сахар";
    }
}

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