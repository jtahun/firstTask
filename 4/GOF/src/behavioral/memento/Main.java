package behavioral.memento;

public class Main {
    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter();
        SaveGame saveGame = new SaveGame();

        hero.showStats();

        hero.moveTo("Лес");
        hero.fight();
        saveGame.save(hero.save());

        hero.moveTo("Горы");
        hero.levelUp();
        hero.fight();

        hero.showStats();

        hero.load(saveGame.loadLastSave());
        hero.showStats();
    }
}
