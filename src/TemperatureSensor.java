import java.util.List;

public class TemperatureSensor extends Sensor{
    private int temperature = -10;

    @Override
    public void checkStatus() {
        System.out.println("Checking Status For Temperature Sensor "+ getName());
        if (!isMalfunctioning()){
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
        else{
            System.out.println("Sensor "+ getName() +" is Malfunctioning");
        }
    }

    @Override
    public void reset() {
        System.out.println("Resetting Temperature Sensor....");
        setMalfunctioning(true);
    }

    public int getTemperature() {
        return this.temperature;
    }
    public void setTemperature(int temperature){
        if (isMalfunctioning()){
            this.temperature = temperature;
            if (temperature<0){
                Notify("Temperature Falls below 0 degrees... Temperature : "+getTemperature());
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public TemperatureSensor(String name){
        super(name);
    }
    public TemperatureSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
