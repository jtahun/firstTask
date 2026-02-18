package behavioral.interpreter;

class TerminalRecipe implements Recipe{
    private final String ingredient;

    public TerminalRecipe(String ingredient){this.ingredient = ingredient;}

    @Override
    public boolean interpret(String ingredients){
        return ingredients.contains(ingredient);
    }
}