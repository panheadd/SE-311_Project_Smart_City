public class CongestionSensorFactory extends SensorFactory{
    @Override
    public CongestionSensor createSensor() {
        return new CongestionSensor("Congestion Sensor");
    }
}
