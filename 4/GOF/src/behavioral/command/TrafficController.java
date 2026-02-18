package behavioral.command;

class TrafficController{
    private Command red;
    private Command yellow;
    private Command green;
    private Command off;

    public TrafficController(Command red, Command yellow, Command green, Command off){
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.off = off;
    }

    public void stop(){
        red.execute();
    }

    public void prepare(){
        yellow.execute();
    }

    public void go(){
        green.execute();
    }

    public void shutdown(){
        off.execute();
    }
}