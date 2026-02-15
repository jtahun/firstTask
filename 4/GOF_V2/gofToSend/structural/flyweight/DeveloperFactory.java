package net.proselyte.gofpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactory {
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
