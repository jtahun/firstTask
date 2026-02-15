
public class Main {
    public static void main(String[] args) {
        Project project =  new ProxyProject("https://wwww.github.com/pro/typeOne");
        project.run();
    }
}


interface Project {
    public void run();
}

class RealProject implements Project{
    private final String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load(){
        System.out.println("Loading project from url "+ url + "...");
    }

    @Override
    public void run() {
        System.out.println("Running project " + url +"...");
    }
}

class ProxyProject implements Project{
    private final String url;
    private  RealProject project;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if(project == null){
            project = new RealProject(url);
        }
        project.run();
    }
}
