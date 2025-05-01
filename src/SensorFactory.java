import java.util.List;

public abstract class SensorFactory {
    abstract public Sensor createSensor();
    abstract public Sensor createSensor(String name);
    abstract public Sensor createSensor(String name , List<Observer> observers);
}
