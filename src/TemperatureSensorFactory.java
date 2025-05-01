import java.util.List;

public class TemperatureSensorFactory extends SensorFactory {
    @Override
    public TemperatureSensor createSensor() {
        return new TemperatureSensor("Temperature Sensor");
    }
    @Override
    public TemperatureSensor createSensor(String name) {
        return new TemperatureSensor(name);
    }
    @Override
    public TemperatureSensor createSensor(String name, List<Observer> observers) {
        return new TemperatureSensor(name,observers);
    }
}
