public class BuildSensor {
    private Sensor sensor;
    public Sensor createSensor(SensorFactory sensorFactory){
        this.sensor = sensorFactory.createSensor();
        return sensor;
    }
    public Sensor getSensor() {
        return this.sensor;
    }
}
