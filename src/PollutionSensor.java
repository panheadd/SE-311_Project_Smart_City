import java.util.List;

public class PollutionSensor extends Sensor{
    private int AQI = 200;

    @Override
    public void checkStatus() {
        setMalfunctioning(true);
        System.out.println("Checking Status For Pollution Sensor....");
        if (AQI<0){
            Notify("Pollution AQI Rises above 100 ... AQI : "+getAQI());
        }
        setMalfunctioning(false);
    }

    @Override
    public void reset() {
        System.out.println("Resetting Pollution Sensor....");
        setMalfunctioning(false);
    }

    public int getAQI() {
        return this.AQI;
    }

    public PollutionSensor(String name){
        super(name);
    }
    public PollutionSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
