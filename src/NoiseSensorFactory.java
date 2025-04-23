public class NoiseSensorFactory extends SensorFactory {
    @Override
    public NoiseSensor createSensor() {
        return new NoiseSensor("NoiseSensor");
    }
}
