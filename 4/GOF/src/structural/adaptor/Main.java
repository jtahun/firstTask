package structural.adaptor;


public class Main {
    public static void main(String[] args) {
        XmlData xml = new XmlData("<name>John</name><age>25</age>");
        JsonData jsonAdapter = new XmlToJsonAdapter(xml);

        System.out.println("XML: " + xml.getXml());
        System.out.println("JSON: " + jsonAdapter.getJson());
    }
}
