package behavioral.interpreter;

public class Main{
    public static void main(String[] args){
        Recipe simplePizza = getSimplePizza();
        Recipe authorPizza = getAuthorPizza();

        System.out.println("It is pass to Simple pizza: " + simplePizza.interpret("тесто сыр"));
        System.out.println("It is pass to Author pizza: " + authorPizza.interpret("тесто сыр трюфель"));
    }

    public static Recipe getSimplePizza(){
        Recipe recipe1 = new TerminalRecipe("тесто");
        Recipe recipe2 = new TerminalRecipe("сыр");
        return new OrRecipe(recipe1, recipe2);
    }

    public static Recipe getAuthorPizza(){
        Recipe recipe1 = new TerminalRecipe("тесто");
        Recipe recipe2 = new TerminalRecipe("сыр");
        Recipe recipe3 = new TerminalRecipe("трюфель");
        Recipe and1 = new AndRecipe(recipe1,recipe2);
        return new AndRecipe(and1, recipe3);
    }
}
