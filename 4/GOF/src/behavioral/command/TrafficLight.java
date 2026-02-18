package behavioral.command;

class TrafficLight{
    public void red(){
        System.out.println("Krasnyj = STOP");
    }

    public void yellow(){
        System.out.println("Zheltyj = Be Ready");
    }

    public void green(){
        System.out.println("Zelenyj = Mozhno dvigatca");
    }

    public void off(){
        System.out.println("Stetofor vykluchen bud ostorozhen");
    }
}
