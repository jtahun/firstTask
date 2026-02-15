
public class Main{
	public static void main(String[] args) {
	  Developer developer = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
	  
	  System.out.println(developer.makeJob());
  }
}

interface Developer{
    public String makeJob();
}

class JavaDeveloper implements Developer{
    @Override
    public String makeJob(){
        return "Java developer make java code.";
    }
}

class DeveloperDecorator implements Developer{
    Developer developer;
    
    public DeveloperDecorator(Developer developer){
        this.developer = developer;
    }
    
    @Override
    public String makeJob(){
        return developer.makeJob();
    }
}

class SeniorJavaDeveloper extends DeveloperDecorator{
    public SeniorJavaDeveloper(Developer developer){
        super(developer);
    }
    
    public String makeCodeReview(){
        return "Make code review.";
    }
    
    @Override
    public String makeJob(){
        return super.makeJob() + makeCodeReview();
    }
}

class JavaTeamLead extends DeveloperDecorator{
    public JavaTeamLead(Developer developer){
        super(developer);
    }
    
    public String sendWeakReport(){
        return "Send weak report to customer";
    }
    
    @Override
    public String makeJob(){
       return super.makeJob() + sendWeakReport();
    }
}