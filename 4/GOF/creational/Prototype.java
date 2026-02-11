
public class Main{
	public static void main(String[] args) {
       Project master = new Project(1,"SuperProject","Code code = new Code(java)");
       System.out.println(master);
       
       ProjectFactory pf = new ProjectFactory(master);
       Project masterClone = pf.cloneProject();
       System.out.println("=".repeat(40));
       System.out.println(masterClone);
    }
	
}


interface Copyable{
    Object copy();
}

class Project implements Copyable{
    private int id;
    private String projectName;
    private String sourceCode;
    
    public Project(int id, String name, String code){
        this.id = id;
        this.projectName = name;
        this.sourceCode = code;
    }
    
    // public setId(int id)
    
    @Override
    public String toString(){
       return ("Project{ "+"id = " + id + " projectName = " + projectName + " sourceCode = " + sourceCode + "\n}");
    }
    
    @Override
    public Object copy(){
        Project copy = new Project(1,projectName, sourceCode);
        return copy;
    }
}

class ProjectFactory{
    Project project;
    
    public ProjectFactory(Project project){
        this.project = project;
    }
    
    public void setProject(Project project){
        this.project = project;
    }
    
    public Project cloneProject(){
        return (Project) project.copy();
    }
}
