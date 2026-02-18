package behavioral.responsobilityChain;

public class Main {
    public static void main(String[] args) {
        SupportHandler basic = new BasicSupport(Level.BASIC);
        SupportHandler advanced = new AdvancedSupport(Level.ADVANCED);
        SupportHandler expert = new ExpertSupport(Level.EXPERT);

        basic.setNextHandler(advanced);
        advanced.setNextHandler(expert);

        System.out.println("=== Запросы в службу поддержки ===");
        System.out.println("\nЗапрос 1: Проблема с паролем");
        basic.handleRequest("Проблема с паролем", Level.BASIC);

        System.out.println("\nЗапрос 2: Ошибка в приложении");
        basic.handleRequest("Ошибка в приложении", Level.ADVANCED);

        System.out.println("\nЗапрос 3: Критический сбой сервера");
        basic.handleRequest("Критический сбой сервера", Level.EXPERT);
    }
}
