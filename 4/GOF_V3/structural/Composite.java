import java.util.List;
import java.util.ArrayList;


public class Main{
	public static void main(String[] args) {
	    Transport t1 = new CarTransport();
	    Transport t2 = new CarTransport();
	    Transport t3 = new ShipTransport();
	    
	    Company company = new Company();
	    company.addDeliveryType(t1);
	    company.addDeliveryType(t2);
	    company.addDeliveryType(t3);
	    
	    company.createDelivery();
  }
}

interface Transport{
    public void delivery();
}

class CarTransport implements Transport{
    @Override
    public void delivery(){
        System.out.println("Car delivery service.");
    }
}

class ShipTransport implements Transport{
    @Override
    public void delivery(){
        System.out.println("Ship delivery service.");
    }
}

class Company{
    List<Transport> company = new ArrayList<>();
    
    public void addDeliveryType (Transport transport){
        company.add(transport);
    }
    
    public void removeDeliveryType(Transport transport){
        company.remove(transport);
    }
    
    public void createDelivery(){
        System.out.println("Company implements delivery...\n");
        for(Transport t : company){
            t.delivery();
        }
    }
}