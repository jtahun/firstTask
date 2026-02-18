package structural.flyweigjt;

import java.util.ArrayList;
import java.util.List;

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