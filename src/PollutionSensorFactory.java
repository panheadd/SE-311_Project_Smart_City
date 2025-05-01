import java.util.List;

public class PollutionSensorFactory extends SensorFactory {
    @Override
    public PollutionSensor createSensor() {
        return new PollutionSensor("Pollution Sensor");
    }
    @Override
    public PollutionSensor createSensor(String name) {
        return new PollutionSensor(name);
    }
    @Override
    public PollutionSensor createSensor(String name, List<Observer> observers) {
        return new PollutionSensor(name,observers);
    }
}
