package structural.facade;

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