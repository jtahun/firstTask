package net.proselyte.gofpatterns.structural.adapter;

public class DatabaseRunner {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.insert();
        database.select();
        database.update();
        database.remove();
    }
}
