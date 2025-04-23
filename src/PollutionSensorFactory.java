public class PollutionSensorFactory extends SensorFactory {
    @Override
    public PollutionSensor createSensor() {
        return new PollutionSensor("Pollution Sensor");
    }
}
