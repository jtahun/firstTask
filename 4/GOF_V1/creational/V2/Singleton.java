class DatabaseConnection {
    
    private static DatabaseConnection instance;
   
    private DatabaseConnection() {
        System.out.println("Создание подключения к БД...");
    }
   
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
   
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
       
        System.out.println("conn1 == conn2: " + (conn1 == conn2)); 
    }
}