package net.proselyte.gofpatterns.creational.factory;

public class Program {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperBySpecialty("hph");
        Developer developer = developerFactory.createDeveloper();

        developer.writeCode();
    }

    static DeveloperFactory createDeveloperBySpecialty(String specialty){
        if(specialty.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        }else if(specialty.equalsIgnoreCase("cpp")){
            return new CppDeveloperFactory();
        }else {
            throw new RuntimeException(specialty + " is unknown specialty.");
        }
    }
}
