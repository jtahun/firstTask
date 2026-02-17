class Pizza {
    private String dough = "";
    private String sauce = "";
    private String topping = "";
    
    public void setDough(String dough) { this.dough = dough; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setTopping(String topping) { this.topping = topping; }
    
    public void showPizza() {
        System.out.println("Пицца с: " + dough + " тесто, " + sauce + " соус, " + topping);
    }
}

// Интерфейс Builder
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    Pizza getPizza();
}

// Конкретный Builder для Гавайской пиццы
class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;
    
    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }
    
    @Override
    public void buildDough() {
        pizza.setDough("тонкое");
    }
    
    @Override
    public void buildSauce() {
        pizza.setSauce("томатный");
    }
    
    @Override
    public void buildTopping() {
        pizza.setTopping("ветчина + ананас");
    }
    
    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Конкретный Builder для Мясной пиццы
class MeatPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;
    
    public MeatPizzaBuilder() {
        this.pizza = new Pizza();
    }
    
    @Override
    public void buildDough() {
        pizza.setDough("толстое");
    }
    
    @Override
    public void buildSauce() {
        pizza.setSauce("барбекю");
    }
    
    @Override
    public void buildTopping() {
        pizza.setTopping("пепперони, бекон, колбаса");
    }
    
    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

// Директор
class Waiter {
    private PizzaBuilder pizzaBuilder;
    
    public void setPizzaBuilder(PizzaBuilder builder) {
        pizzaBuilder = builder;
    }
    
    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }
    
    public void constructPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

// Использование
public class PizzaBuilderDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        
        // Готовим Гавайскую пиццу
        waiter.setPizzaBuilder(new HawaiianPizzaBuilder());
        waiter.constructPizza();
        Pizza hawaiianPizza = waiter.getPizza();
        hawaiianPizza.showPizza();
        
        // Готовим Мясную пиццу
        waiter.setPizzaBuilder(new MeatPizzaBuilder());
        waiter.constructPizza();
        Pizza meatPizza = waiter.getPizza();
        meatPizza.showPizza();
    }
}