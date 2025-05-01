import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Sensor {
    protected String name;
    protected boolean malfunctioning;
    protected List<Observer> observers;

    public void attach(Observer observer){
        this.observers.add(observer);
    }
    public void detach(Observer observer){
        for (int i = 0; i< observers.size(); i++) {
            if (Objects.equals(observers.get(i).getName(), observer.getName())) {
                observers.remove(i);
                return;
            }
        }
    }
    public void Notify(String message) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this,message);
        }
    }
    public void checkStatus() {
        if (!isMalfunctioning()){
            System.out.println("Checking Status For Sensor " + getName()+ " : "+"Sensor "+ getName() +" is not Malfunctioning");
        }
        else{
            System.out.println("Checking Status For Sensor " + getName()+ " : "+"Sensor "+ getName() +" is Malfunctioning");
        }
    }
    public void reset() {
        System.out.println("Resetting Sensor "+ getName()+"...");
        setMalfunctioning(true);
    }

    public abstract void setValue(int value);

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMalfunctioning() {
        return this.malfunctioning;
    }

    public void setMalfunctioning(boolean malfunctioning) {
        this.malfunctioning = malfunctioning;
    }

    public Sensor(String name){
        this.name = name;
        this.malfunctioning = true;
        this.observers = new ArrayList<>();
    }
    public Sensor(String name,List<Observer> observers){
        this.name = name;
        this.malfunctioning = true;
        this.observers = observers;
    }

}


class PollutionSensor extends Sensor{
    private int AQI = 200;

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

class TemperatureSensor extends Sensor{
    private int temperature = -10;

    @Override
    public void setValue(int temperature) {
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

class NoiseSensor extends Sensor{
    private int noiseLevel = 90;
    @Override
    public void setValue(int noiseLevel) {
        if (isMalfunctioning()){
            this.noiseLevel = noiseLevel;
            if (noiseLevel>85){
                Notify("Noise Level rises above 85dB... Noise Level : "+getNoiseLevel()+ "dB");
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public int getNoiseLevel() {
        return this.noiseLevel;
    }
    public void setNoiseLevel(int noiseLevel){
        if (isMalfunctioning()){
            this.noiseLevel = noiseLevel;
            if (noiseLevel>85){
                Notify("Noise Level rises above 85dB... Noise Level : "+getNoiseLevel()+ "dB");
            }
        }
        else {
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
    }

    public NoiseSensor(String name){
        super(name);
    }
    public NoiseSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
class CongestionSensor extends Sensor{
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

