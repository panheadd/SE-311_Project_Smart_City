import java.util.List;

public class NoiseSensor extends Sensor{
    private int noiseLevel = 90;

    @Override
    public void checkStatus() {
        setMalfunctioning(true);
        System.out.println("Checking Status For Noise Sensor....");
        if (noiseLevel<0){
            Notify("Noise Level is above 85dB ... Noise Level : "+getNoiseLevel());
        }
        setMalfunctioning(false);
    }

    @Override
    public void reset() {
        System.out.println("Resetting Noise Sensor....");
        setMalfunctioning(false);
    }

    public int getNoiseLevel() {
        return this.noiseLevel;
    }

    public NoiseSensor(String name){
        super(name);
    }
    public NoiseSensor(String name, List<Observer> observers){
        super(name,observers);
    }
}
