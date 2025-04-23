public class BuildSensor {
    private Sensor sensor;
    public BuildSensor(SensorFactory sensorFactory){
        this.sensor = sensorFactory.createSensor();
    }

    public Sensor getSensor() {
        return this.sensor;
    }
}
