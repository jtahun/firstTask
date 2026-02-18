package structural.proxy;

class RealDocument implements Document{
    private final String url;

    public RealDocument(String url){
        this.url = url;
        download();
    }

    public void download(){
        System.out.println("Downloading document from " + url + "..." );
    }

    @Override
    public void open(){
        System.out.println("Opening document from " + url + "...");
    }
}