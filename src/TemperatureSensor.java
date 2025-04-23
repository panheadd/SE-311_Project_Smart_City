import java.util.List;

public class TemperatureSensor extends Sensor{
    private int temperature = -10;

    @Override
    public void checkStatus() {
        setMalfunctioning(true);
        System.out.println("Checking Status For Temperature Sensor....");
        if (temperature<0){
            Notify("Temperature Falls below 0 degrees... Temperature : "+getTemperature());
        }
        setMalfunctioning(false);
    }

    @Override
    public void reset() {
        System.out.println("Resetting Temperature Sensor....");
        setMalfunctioning(false);
    }

    public int getTemperature() {
        return this.temperature;
    }

    public TemperatureSensor(String name){
        super(name);
    }
    public TemperatureSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
