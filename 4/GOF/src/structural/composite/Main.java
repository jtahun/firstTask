package structural.composite;

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