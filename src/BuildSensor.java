import java.util.List;

public class BuildSensor {
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
