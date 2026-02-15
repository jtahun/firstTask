import java.util.List;
import java.util.ArrayList;


public class Main{
	public static void main(String[] args) {
	    Developer dj = new JavaDeveloper();
	    Developer dj2 = new JavaDeveloper();
	    Developer dc = new CppDeveloper();
	    
	    Team team = new Team();
	    team.addDeveloper(dj);
	    team.addDeveloper(dj2);
	    team.addDeveloper(dc);
	    
	    team.createProject();
  }
}

interface Developer{
    public void writeCode();
}

class JavaDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("Java developer make java code.");
    }
}

class CppDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("C++ developer make c++ code.");
    }
}

class Team{
    List<Developer> team = new ArrayList<>();
    
    public void addDeveloper(Developer developer){
        team.add(developer);
    }
    
    public void removeDeveloper(Developer developer){
        team.remove(developer);
    }
    
    public void createProject(){
        System.out.println("Team create project...\n");
        for(Developer d : team){
            d.writeCode();
        }
    }
}