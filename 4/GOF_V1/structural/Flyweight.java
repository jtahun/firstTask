

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = new DeveloperFactory();
        List<Developer> developers = new ArrayList<>();
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));

        for(Developer developer: developers){
            developer.writeCode();
        }
    }
}


interface Developer {
    public void writeCode();
}

class CppDeveloper implements Developer{
    public void writeCode(){
        System.out.println("C++ developer do job...");
    }
}

class JavaDeveloper implements Developer{
    public void writeCode(){
        System.out.println("Java developer do job...");
    }
}


class DeveloperFactory {
    private static final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloperBySpecialty(String specialty){
        Developer developer = developers.get(specialty);

        if(developer == null){
            switch (specialty){
                case "java":
                    System.out.println("Hiring Java Developer...");
                    developer = new JavaDeveloper();
                    break;
                case "c++":
                    System.out.println("Hiring C++ Developer...");
                    developer = new CppDeveloper();
                    break;
            }
            developers.put(specialty,developer);
        }
        return developer;
    }
}

