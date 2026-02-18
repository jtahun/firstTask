package creational.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();

        System.out.println("conn1 == conn2: " + (conn1 == conn2));
    }
}