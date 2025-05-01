import java.util.List;

public interface Command {
    public void execute();
}

class ResetCommand implements Command{
    private Sensor sensor;
    @Override
    public void execute() {
        this.sensor.reset();
    }
    public ResetCommand(Sensor sensor){
        this.sensor = sensor;
    }
}
class StatusQueryCommand implements Command{
    private Sensor sensor;
    @Override
    public void execute() {
        this.sensor.checkStatus();
    }
    public StatusQueryCommand(Sensor sensor){
        this.sensor = sensor;
    }
}
class CommandExecutor{
    void runCommand(Command command){
        command.execute();
    }
}
class Engineer {
    private CommandExecutor executor = new CommandExecutor();

    public void resetSensors(List<Sensor> sensors){
        for (Sensor s : sensors) {
            executor.runCommand(new ResetCommand(s));
        }
    }
}
class DataMonitoringDivision {
    private static DataMonitoringDivision instance = new DataMonitoringDivision();
    private CommandExecutor executor = new CommandExecutor();

    private DataMonitoringDivision() {}

    public static DataMonitoringDivision getInstance() {
        return instance;
    }

    public void monitor(List<Sensor> sensors) {
        int count = 0;
        for (Sensor s : sensors) {
            executor.runCommand(new StatusQueryCommand(s));
            if (s.isMalfunctioning()) {
                count++;
            }
        }
        System.out.println("Number of malfunctioning sensors : " + count);
    }
}

