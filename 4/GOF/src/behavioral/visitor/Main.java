package behavioral.visitor;

public class Main {
    public static void main(String[] args) {
        BuildingProject project = new BuildingProject();
        Architect junior = new JuniorArchitect();
        Architect senior = new SeniorArchitect();

        System.out.println("Проект от Junior архитектора:");
        project.beDesigned(junior);

        System.out.println("\nПроект от Senior архитектора:");
        project.beDesigned(senior);
    }
}