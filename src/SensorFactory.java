import java.util.List;

public abstract class SensorFactory {
    abstract public Sensor createSensor();
    abstract public Sensor createSensor(String name);
    abstract public Sensor createSensor(String name , List<Observer> observers);
}

class BuildSensor {
    private Sensor sensor;
    public Sensor createSensor(SensorFactory sensorFactory){
        this.sensor = sensorFactory.createSensor();
        return sensor;
    }
    public Sensor createSensor(SensorFactory sensorFactory,String name){
        this.sensor = sensorFactory.createSensor(name);
        return sensor;
    }
    public Sensor createSensor(SensorFactory sensorFactory, String name, List<Observer> observers){
        this.sensor = sensorFactory.createSensor( name,  observers);
        return sensor;
    }
    public Sensor getSensor() {
        return this.sensor;
    }
}
class CongestionSensorFactory extends SensorFactory {
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
class NoiseSensorFactory extends SensorFactory {
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
class PollutionSensorFactory extends SensorFactory {
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
class TemperatureSensorFactory extends SensorFactory {
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

