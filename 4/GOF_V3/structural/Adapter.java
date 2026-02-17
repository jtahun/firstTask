interface JsonData {
    String getJson();
}

class XmlData {
    private String xml;
    
    public XmlData(String xml) {
        this.xml = xml;
    }
    
    public String getXml() {
        return xml;
    }
}

class XmlToJsonAdapter implements JsonData {
    private XmlData xmlData;
    
    public XmlToJsonAdapter(XmlData xmlData) {
        this.xmlData = xmlData;
    }
    
    @Override
    public String getJson() {
        String xml = xmlData.getXml();
        String json = xml.replace("<", "\"")
                         .replace(">", "\":")
                         .replace("/", "");
        return "{ " + json + " }";
    }
}

public class Main {
    public static void main(String[] args) {
        XmlData xml = new XmlData("<name>John</name><age>25</age>");
        JsonData jsonAdapter = new XmlToJsonAdapter(xml);
        
        System.out.println("XML: " + xml.getXml());
        System.out.println("JSON: " + jsonAdapter.getJson());
    }
}