public class StatusQueryCommand implements Command{
    private Sensor sensor;
    @Override
    public void execute() {
        this.sensor.checkStatus();
    }
    public StatusQueryCommand(Sensor sensor){
        this.sensor = sensor;
    }
}
