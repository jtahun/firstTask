package structural.adaptor;

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
