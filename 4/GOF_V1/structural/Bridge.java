
public class Main{
	public static void main(String[] args) {
	    Program[] programs = {new BankSystem(new JavaDeveloper()), new ExchangeStock(new CppDeveloper())};
	    
	    for(Program p : programs){
	        p.developerProgram();
	    }
    }
}

interface Developer{
    public void writeCode();
}

class JavaDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("Java developer make java code.");
    }
}

class CppDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("C++ developer make c++ code.");
    }
}

abstract class Program{
    protected Developer developer;
    
    protected Program(Developer developer){this.developer = developer;}
    
    public abstract void developerProgram();
}

class BankSystem extends Program{
    protected BankSystem(Developer developer){super(developer);}
    
    @Override
    public void developerProgram(){
        System.out.println("Team makes BankSystem.");
        developer.writeCode();
    }
}

class ExchangeStock extends Program{
    protected ExchangeStock(Developer developer) {super(developer);}
    
    @Override
    public void developerProgram(){
        System.out.println("And other team makes ExchangeStock.");
        developer.writeCode();
    }
}


