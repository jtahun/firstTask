/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	  DeveloperFactory devFac = createDeveloperBySpecialty("php");
	  Developer developer = devFac.createDeveloper();
	  developer.writeCode();
	}
	
	static DeveloperFactory createDeveloperBySpecialty(String specialty){
	  if(specialty.equalsIgnoreCase("java")){
	      return new JavaDeveloperFactory();
	  }else if(specialty.equalsIgnoreCase("c++")){
	      return new CppDeveloperFactory();
	  }else if(specialty.equalsIgnoreCase("php")){
	      return new PhpDeveloperFactory();
	  }
	  else{
	      throw new RuntimeException(specialty + " it is unknowed specialty.");
	  }
	     
	      
	}
}

interface Developer{
  void writeCode();
}

interface DeveloperFactory{
   Developer createDeveloper();
}

class JavaDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("Java developer does his job.");
    }
}

class CppDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("C++ developer does his job.");
    }
}

class PhpDeveloper implements Developer{
    @Override
    public void writeCode(){
        System.out.println("PHP developer does his job");
    }
}


class JavaDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper(){
        return new JavaDeveloper();
    }
}

class CppDeveloperFactory implements DeveloperFactory{
    @Override
    public Developer createDeveloper(){
        return new CppDeveloper();
    }
}

class PhpDeveloperFactory implements DeveloperFactory{
    @Override 
    public Developer createDeveloper(){
        return new PhpDeveloper();
    }
}