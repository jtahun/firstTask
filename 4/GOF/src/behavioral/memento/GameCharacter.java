package behavioral.memento;

class GameCharacter {
    private int health = 100;
    private int level = 1;
    private String location = "Старт";

    public void fight() {
        health -= 30;
        System.out.println("Бой! Здоровье: " + health);
    }

    public void levelUp() {
        level++;
        System.out.println("Уровень повышен: " + level);
    }

    public void moveTo(String location) {
        this.location = location;
        System.out.println("Перемещение в: " + location);
    }

    public void showStats() {
        System.out.println("Здоровье: " + health +
                ", Уровень: " + level +
                ", Локация: " + location);
    }

    public CharacterMemento save() {
        return new CharacterMemento(health, level, location);
    }

    public void load(CharacterMemento memento) {
        this.health = memento.getHealth();
        this.level = memento.getLevel();
        this.location = memento.getLocation();
        System.out.println("Загружено сохранение");
    }

    static class CharacterMemento {
        private final int health;
        private final int level;
        private final String location;

        CharacterMemento(int health, int level, String location) {
            this.health = health;
            this.level = level;
            this.location = location;
        }

        int getHealth() { return health; }
        int getLevel() { return level; }
        String getLocation() { return location; }
    }
}