import java.util.List;

public class CongestionSensor extends Sensor{
    private int carSpeeds = 200;

    @Override
    public void checkStatus() {
        setMalfunctioning(true);
        System.out.println("Checking Status For Congestion Sensor....");
        if (carSpeeds<0){
            Notify("Congestion Rises Car Speeds are above 10 KM/H ... Car Speeds : "+getCarSpeeds());
        }
        setMalfunctioning(false);
    }

    @Override
    public void reset() {
        System.out.println("Resetting Congestion Sensor....");
        setMalfunctioning(false);
    }

    public int getCarSpeeds() {
        return this.carSpeeds;
    }

    public CongestionSensor(String name){
        super(name);
    }
    public CongestionSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
