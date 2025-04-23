public class TemperatureSensorFactory extends SensorFactory {
    @Override
    public TemperatureSensor createSensor() {
        return new TemperatureSensor("Temperature Sensor");
    }
}
