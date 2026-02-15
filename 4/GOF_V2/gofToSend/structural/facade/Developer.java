package net.proselyte.gofpatterns.structural.facade;

public class Developer {
    public void doJobBeforeDeadline(BugTracker bugTracker){
        if (bugTracker.isActiveSprint()){
            System.out.println("Developer solving problems...");
        }else{
            System.out.println("Developer is reading Habr...");
        }
    }
}
