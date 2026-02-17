
public class Main{
	public static void main(String[] args) {
	  TripFacade tf = new TripFacade();
	  tf.compile();
  }
}

class OpenCar{
    public void opening (){System.out.println("Open car");}
}

class SitInCar{
   public void sitting(){System.out.println("Sit in car");}
}

class ToggleEngine{
   public void turnOnEngine(){System.out.println("Turn on engine");}
}

class Drive{
   public void driving(){System.out.println("Driving far away");}
}


class TripFacade{
  private OpenCar openCar;
  private SitInCar sitInCar;
  private ToggleEngine toggleEngine;
  private Drive drive;
  
  public TripFacade(){
      openCar = new OpenCar();
      sitInCar = new SitInCar();
      toggleEngine = new ToggleEngine();
      drive = new Drive();
  }
  
  public void compile(){
      openCar.opening();
      sitInCar.sitting();
      toggleEngine.turnOnEngine();
      drive.driving();
  }
}