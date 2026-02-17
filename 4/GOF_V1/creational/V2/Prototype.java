
public class Main{
	public static void main(String[] args) {
       Car car = new Car("Toyota","Silver");
       System.out.println(car);
       
       CarFactory cf = new CarFactory(car);
       Car carClone = cf.cloneCar();
       System.out.println("=".repeat(40));
       System.out.println(carClone);
    }
	
}


interface Copyable{
    Object copy();
}

class Car implements Copyable{
    private String name;
    private String color;
   
    
    public Car(String name, String color){
        this.name = name;
        this.color = color;
    }
    
    
    @Override
    public String toString(){
       return ("Car{ "+"name = " + name + " color = " + color +  "}\n");
    }
    
    @Override
    public Object copy(){
        Car car = new Car(name, color);
        return car;
    }
}

class CarFactory{
    Car car;
    
    public CarFactory(Car car){
        this.car = car;
    }
    
    public void setCar(Car car){
        this.car = car;
    }
    
    public Car cloneCar(){
        return (Car) car.copy();
    }
}
