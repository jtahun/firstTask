package behavioral.memento;

import java.util.Stack;

class SaveGame {
    private Stack<GameCharacter.CharacterMemento> saves = new Stack<>();

    public void save(GameCharacter.CharacterMemento memento) {
        saves.push(memento);
        System.out.println("Игра сохранена (слот " + saves.size() + ")");
    }

    public GameCharacter.CharacterMemento loadLastSave() {
        if (!saves.isEmpty()) {
            return saves.pop();
        }
        return null;
    }
}