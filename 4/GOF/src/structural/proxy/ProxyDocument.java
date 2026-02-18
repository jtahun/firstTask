package structural.proxy;

class ProxyDocument implements Document{
    private final String url;
    private RealDocument document;

    public ProxyDocument(String url){
        this.url = url;
    }

    @Override
    public void open(){
        if(document == null){
            document = new RealDocument(url);
        }
        document.open();
    }
}