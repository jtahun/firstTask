package behavioral.mediator;

public class Main{
    public static void main(String[] args){
        ControlTower tower = new ControlTower();
        Aircraft plane1 = new PassengerAircraft("Boeing 737", tower);
        Aircraft plane2 = new PassengerAircraft("Tu-214", tower);
        Aircraft military = new MilitaryAircraft("Su-57", tower);

        tower.setTowerController(military);
        tower.addAircraft(plane1);
        tower.addAircraft(plane2);

        plane1.sendMessage("Request for landing");
        plane2.sendMessage("Request for takeoff");
        military.sendMessage("Request emergency landing");
    }
}