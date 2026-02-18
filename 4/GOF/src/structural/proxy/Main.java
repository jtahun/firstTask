package structural.proxy;

public class Main{
    public static void main(String[] args){
        Document document = new ProxyDocument("https://www.docs.com/secret/confidential");
        document.open();
    }
}