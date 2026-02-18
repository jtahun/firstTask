package behavioral.interpreter;

class OrRecipe implements Recipe{
    private final Recipe recipe1;
    private final Recipe recipe2;

    public OrRecipe(Recipe r1, Recipe r2){
        this.recipe1 = r1;
        this.recipe2 = r2;
    }

    @Override
    public boolean interpret(String ingredients){
        return recipe1.interpret(ingredients) || recipe2.interpret(ingredients);
    }
}