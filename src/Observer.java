public interface Observer {
    public void update(Sensor sensor,String msg);
    public String getName();
}


class Citizen implements Observer{
    private Sensor sensor;
    private String name;
    private String sensorName;
    private boolean isSensorMalfunction;

    @Override
    public void update(Sensor sensor,String msg) {
        this.sensor = sensor;
        sensorName = this.sensor.getName();
        isSensorMalfunction = this.sensor.isMalfunctioning();
        System.out.println("Notified " + getName() + " of " +" Sensor "+ this.sensorName +
                "'s " + "to " + msg+"... Sensor Malfunctioning : "+isSensorMalfunction);
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
    public Citizen(String name){
        this.name = name;
    }
}

