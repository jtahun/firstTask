public class Main{
    public static void main(String[] args){
        ProgramLoger.getLogger().addLog("First log...");
        ProgramLoger.getLogger().addLog("Second log...");
        ProgramLoger.getLogger().addLog("Third log...");
        
        ProgramLoger.getLogger().showLogfile();
    }
}


class ProgramLoger{
    private static ProgramLoger logger;
    private static String logfile = "This is log file.\n\n";
    
    public static synchronized ProgramLoger getLogger(){
        if(logger == null){
            return new ProgramLoger();
        }
        
        return logger;
    }
    
    public ProgramLoger(){}
    
    public void addLog(String logtext){
        logfile += logtext+"\n";
    }
    
    public void showLogfile(){
        System.out.println(logfile);
    }
}