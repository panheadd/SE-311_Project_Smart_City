import java.util.List;

public class PollutionSensor extends Sensor{
    private int AQI = 200;

    @Override
    public void checkStatus() {
        System.out.println("Checking Status For Pollution Sensor "+ getName());
        if (!isMalfunctioning()){
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
        else{
            System.out.println("Sensor "+ getName() +" is Malfunctioning");
        }
    }

    @Override
    public void reset() {
        System.out.println("Resetting Pollution Sensor....");
        setMalfunctioning(true);
    }

    @Override
    public void setValue(int AQI) {
        if (isMalfunctioning()){
            this.AQI = AQI;
            if (AQI>100){
                Notify("AQI rises above 100... AQI : "+getAQI());
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public int getAQI() {
        return this.AQI;
    }
    public void setAQI(int AQI){
        if (isMalfunctioning()){
            this.AQI = AQI;
            if (AQI>100){
                Notify("AQI rises above 100... AQI : "+getAQI());
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public PollutionSensor(String name){
        super(name);
    }
    public PollutionSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
