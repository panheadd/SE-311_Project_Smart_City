import java.util.List;

public class NoiseSensorFactory extends SensorFactory {
    @Override
    public NoiseSensor createSensor() {
        return new NoiseSensor("NoiseSensor");
    }
    @Override
    public NoiseSensor createSensor(String name) {
        return new NoiseSensor(name);
    }
    @Override
    public NoiseSensor createSensor(String name, List<Observer> observers) {
        return new NoiseSensor(name,observers);
    }
}
