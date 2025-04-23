public class ResetCommand implements Command{
    private Sensor sensor;
    @Override
    public void execute() {
        this.sensor.reset();
    }
    public ResetCommand(Sensor sensor){
        this.sensor = sensor;
    }
}
