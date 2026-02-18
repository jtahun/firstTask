package behavioral.mediator;

import java.util.List;
import java.util.ArrayList;

class ControlTower implements ControlMediator{
    Aircraft towerController;
    List<Aircraft> planes = new ArrayList<>();

    public void setTowerController(Aircraft controller){
        this.towerController = controller;
    }

    public void addAircraft(Aircraft plane){
        planes.add(plane);
    }

    @Override
    public void sendMessage(String msg, Aircraft planeSender){
        System.out.println(" Control Tower broadcasting message...");

        for(Aircraft a: planes){
            if(a != planeSender){
                a.receiveMessage(msg);
            }
        }
        if(towerController != planeSender){
            towerController.receiveMessage(msg);
        }
    }
}
