import java.util.List;

public class CongestionSensor extends Sensor{
    private int carSpeeds = 1;

    @Override
    public void setValue(int carSpeeds) {
        if (isMalfunctioning()){
            this.carSpeeds = carSpeeds;
            if (carSpeeds<10){
                Notify("Congestion Level rises, car speeds below 10 KM/H... Car Speeds : "+getCarSpeeds()+ "KM/H");
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public int getCarSpeeds() {
        return this.carSpeeds;
    }
    public void setCarSpeeds(int carSpeeds){
        if (isMalfunctioning()){
            this.carSpeeds = carSpeeds;
            if (carSpeeds<10){
                Notify("Congestion Level rises, car speeds below 10 KM/H... Car Speeds : "+getCarSpeeds()+ "dB");
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public CongestionSensor(String name){
        super(name);
    }
    public CongestionSensor(String name, List<Observer> observers){
        super(name,observers);
    }

}
