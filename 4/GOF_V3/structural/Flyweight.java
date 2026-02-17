

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CitrusFactory citrusFactory = new CitrusFactory();
        List<Citrus> cintons = new ArrayList<>();
        cintons.add(citrusFactory.getCitrusByCode("OR"));
        cintons.add(citrusFactory.getCitrusByCode("OR"));
        cintons.add(citrusFactory.getCitrusByCode("MAND"));
        cintons.add(citrusFactory.getCitrusByCode("MAND"));
        cintons.add(citrusFactory.getCitrusByCode("MAND"));

        for(Citrus citrus: cintons){
            citrus.taste();
        }
    }
}


interface Citrus{
 void taste();
}

class Mandarin implements Citrus{
  @Override
  public void taste(){
    System.out.println("Mandarin sladkij i sochnyj");
  }
}

class Orange implements Citrus{
  @Override
  public void taste(){
    System.out.println("Apelcin kislo-sladkij i mnogo vitamina C!");
  }
}



class CitrusFactory {
    private static final Map<String, Citrus> cintons = new HashMap<>();

    public Citrus getCitrusByCode(String code){		
		
        Citrus citrus = cintons.get(code);

        if(citrus == null){
            switch (code){
                case "OR":
                    System.out.println("Imlements Orange delivery...");
                    citrus = new Orange();
                    break;
                case "MAND":
                    System.out.println("Imlements Mandarin delivery***");
                    citrus = new Mandarin();
                    break;
            }
            cintons.put(code,citrus);
        }
        return citrus;
    }
}

