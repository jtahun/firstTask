package net.proselyte.gofpatterns.behavioral.command;

public class Database {
    public void insert(){
        System.out.println("Insert record...");
    }
    public void update(){
        System.out.println("Update record...");
    }
    public void select(){
        System.out.println("Select record...");
    }
    public void delete(){
        System.out.println("Delete record...");
    }
}
