public class BuildSensor {
    private Sensor sensor;
    public void createSensor(SensorFactory sensorFactory){
        this.sensor = sensorFactory.createSensor();
    }
    public Sensor getSensor() {
        return this.sensor;
    }
}
