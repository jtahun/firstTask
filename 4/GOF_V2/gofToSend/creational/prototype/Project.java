package net.proselyte.gofpatterns.creational.prototype;

public class Project implements Copyable{
    private int id;
    private String projectName;
    private String sourceCode;

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public Project(int id, String projectName, String sourceCode) {
        this.id = id;
        this.projectName = projectName;
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy(){
        return new Project(id,projectName,sourceCode);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}
