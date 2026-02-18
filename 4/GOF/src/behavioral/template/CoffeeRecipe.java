package behavioral.template;

class CoffeeRecipe extends BeverageRecipe {
    @Override
    public void brew() {
        System.out.println("Завариваем молотый кофе");
    }

    @Override
    public void addCondiments() {
        System.out.println("Добавляем молоко и сахар");
    }
}