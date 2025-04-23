import java.util.List;

public class NoiseSensor extends Sensor{
    private int noiseLevel = 90;

    @Override
    public void checkStatus() {
        System.out.println("Checking Status For Noise Sensor "+ getName());
        if (!isMalfunctioning()){
            System.out.println("Sensor "+ getName() +" is not Malfunctioning");
        }
        else{
            System.out.println("Sensor "+ getName() +" is Malfunctioning");
        }
    }

    @Override
    public void reset() {
        System.out.println("Resetting Noise Sensor....");
        setMalfunctioning(true);
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
