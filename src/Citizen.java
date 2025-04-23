public class Citizen implements Observer{
    private Sensor sensor;
    private String name;
    private String sensorName;
    private boolean isSensorMalfunction;

    @Override
    public void update(Sensor sensor,String msg) {
        this.sensor = sensor;
        sensorName = this.sensor.getName();
        isSensorMalfunction = this.sensor.isMalfunctioning();
        System.out.println("Notified " + getName() + " of " + this.sensorName +
                "'s " + " to " + msg);
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
