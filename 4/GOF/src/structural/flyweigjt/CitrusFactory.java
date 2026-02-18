package structural.flyweigjt;

import java.util.HashMap;
import java.util.Map;


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