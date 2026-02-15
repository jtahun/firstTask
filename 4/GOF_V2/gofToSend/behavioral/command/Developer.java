package net.proselyte.gofpatterns.behavioral.command;

public class Developer {
    Command insert;
    Command update;
    Command delete;
    Command select;

    public Developer(Command insert, Command update, Command delete, Command select) {
        this.insert = insert;
        this.update = update;
        this.delete = delete;
        this.select = select;
    }

    public void insertRecord(){
        insert.execute();
    }

    public void updateRecord(){
        update.execute();
    }

    public void deleteRecord(){
        delete.execute();
    }
    public void selectRecord(){
        select.execute();
    }
}


