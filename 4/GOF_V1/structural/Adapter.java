
public class Main{
	public static void main(String[] args) {
       Database database = new AdapterJavaToDatabase();
       
       database.insert();
       database.update();
       database.select();
       database.delete();
    }
}


interface Database{
    public void insert();
    public void update();
    public void select();
    public void delete();
}


class JavaApplication{
    public void saveObject(){
        System.out.println("Saving Java object.");
    }
    
    public void updateObject(){
        System.out.println("Update Java object.");
    }
    
    public void loadObject(){
        System.out.println("Loading Java object.");
    }
    
    public void deleteObject(){
        System.out.println("Delete Java Object.");
    }
}

class AdapterJavaToDatabase extends JavaApplication implements Database{
    @Override
    public void insert(){saveObject();}
    
    @Override
    public void update(){updateObject();}
    
    @Override 
    public void select(){loadObject();}
    
    @Override
    public void delete(){deleteObject();}
}