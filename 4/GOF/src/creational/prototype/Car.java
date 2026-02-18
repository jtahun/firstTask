package creational.prototype;

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