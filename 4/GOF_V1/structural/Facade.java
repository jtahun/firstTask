
public class Main{
	public static void main(String[] args) {
	  Workflow wf = new Workflow();
	  wf.solveProblems();
  }
}

class Job{
    public void doJob(){
        System.out.println("Job in progress...");
    }
}

class BugTracker{
    private boolean activeStrint;
    
    public boolean isSprintActive(){
        return activeStrint;
    }
    
    public void startSprint(){
        System.out.println("Sprint started.");
        activeStrint = true;
    }
    
    public void stopSprint(){
        System.out.println("Sprint stoped.");
        activeStrint = false;
    }
}

class Developer{
    public void doJobBeforeDeadLine(BugTracker bt){
        if(bt.isSprintActive()){
            System.out.println("Do job solving problems...");
        }else{
            System.out.println("Read Habr and drink coffee...");
        }
    }
}

class Workflow{
    Developer developer = new Developer();
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();
    
    public void solveProblems(){
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadLine(bugTracker);
    }
    
}