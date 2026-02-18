package behavioral.template;

abstract class BeverageRecipe {
    public void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        System.out.println("Напиток готов!\n");
    }

    private void boilWater() {
        System.out.println("Кипятим воду");
    }

    private void pourInCup() {
        System.out.println("Наливаем в чашку");
    }

    public abstract void brew();
    public abstract void addCondiments();
}
