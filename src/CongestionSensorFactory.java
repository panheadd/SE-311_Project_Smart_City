import java.util.List;

public class CongestionSensorFactory extends SensorFactory {
    @Override
    public CongestionSensor createSensor() {
        return new CongestionSensor("Congestion Sensor");
    }
    @Override
    public CongestionSensor createSensor(String name) {
        return new CongestionSensor(name);
    }
    @Override
    public CongestionSensor createSensor(String name, List<Observer> observers) {
        return new CongestionSensor(name,observers);
    }
}
