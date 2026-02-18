package structural.composite;

import java.util.List;
import java.util.ArrayList;


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