package behavioral.template;

class TeaRecipe extends BeverageRecipe {
    @Override
    public void brew() {
        System.out.println("Завариваем чайный пакетик");
    }

    @Override
    public void addCondiments() {
        System.out.println("Добавляем лимон и сахар");
    }
}
