package behavioral.template;

public class Main {
    public static void main(String[] args) {
        BeverageRecipe tea = new TeaRecipe();
        BeverageRecipe coffee = new CoffeeRecipe();

        System.out.println("Приготовление чая:");
        tea.prepare();

        System.out.println("Приготовление кофе:");
        coffee.prepare();
    }
}