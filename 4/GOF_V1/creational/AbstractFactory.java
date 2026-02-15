public class Main{
    public static void main(String[] args){
        ProjectTeamFactory[] twoDirect = {new BankTeamFactory(), new WebSiteProjectTeamFactory()};
        for(ProjectTeamFactory ptf : twoDirect){
            Developer dev = ptf.getDeveloper();
            Tester tester = ptf.getTester();
            ProjectManager pm = ptf.getPM();
            System.out.println("\n Every team make its job in their project...\n");
            dev.writeCode();
            tester.testActions();
            pm.manageProject();
        }
    }
}
    

interface Developer{
    void writeCode();
}

interface Tester{
    void testActions();
}

interface ProjectManager{
    void manageProject();
}

interface ProjectTeamFactory{
    Developer getDeveloper();
    Tester getTester();
    ProjectManager getPM();
}

class JavaDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("Java developer make java code...");
    }
}

class QATester implements Tester{
    @Override
    public void testActions(){
        System.out.println("QA worker do his job...");
    }
}

class FinTechPM implements ProjectManager{
    @Override 
    public void manageProject(){
        System.out.println("PM manages finTech project...");
    }
}

class BankTeamFactory implements ProjectTeamFactory{
    @Override 
    public Developer getDeveloper(){
        return new JavaDeveloper();
    }
    
    @Override
    public Tester getTester(){
        return new QATester();
    }
    
    @Override
    public ProjectManager getPM(){
        return new FinTechPM();
    }
}

class PhpDeveloper implements Developer{
    @Override
    public void writeCode(){
      System.out.println("Php developer make website project");    
    }
}

class ManualTester implements Tester{
    @Override 
    public void testActions(){
        System.out.println("Manual tester make his job...");
    }
}

class WebProjectsPM implements ProjectManager{
    @Override
    public void manageProject(){
        System.out.println("Project Manager of WebSite");
    }
}

class WebSiteProjectTeamFactory implements ProjectTeamFactory{
    @Override
    public Developer getDeveloper(){
        return new PhpDeveloper();
    }
    
    @Override
    public Tester getTester(){
        return new ManualTester();
    }
    
    @Override 
    public ProjectManager getPM(){
        return new WebProjectsPM();
    }
}