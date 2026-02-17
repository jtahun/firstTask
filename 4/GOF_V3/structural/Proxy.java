interface Document{
  void open();
}

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

public class Main{
  public static void main(String[] args){
	Document document = new ProxyDocument("https://www.docs.com/secret/confidential");  
	document.open();
  }
}