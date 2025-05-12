import java.util.List;


// YUNUS ERDEM GÖKDAĞ
// DENİZ  YETİŞ
// BAŞAR KOCABAŞ
// FATİH ANAMASLI


//Abstract Command
public interface Command {
    public void execute();
}


//Concrete Reset Command
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

//Concrete Status Query Command
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

//Command Executor Invoker
class CommandExecutor{
    void runCommand(Command command){
        command.execute();
    }
}

//Engineer Client
class Engineer {
    private CommandExecutor executor = new CommandExecutor();

    public void resetSensors(List<Sensor> sensors){
        System.out.println("Resetting...");
        for (Sensor s : sensors) {
            executor.runCommand(new ResetCommand(s));
        }
    }
}

// DMD Client
class DataMonitoringDivision {
    private static DataMonitoringDivision instance = new DataMonitoringDivision();
    private CommandExecutor executor = new CommandExecutor();

    private DataMonitoringDivision() {}

    public static DataMonitoringDivision getInstance() {
        return instance;
    }

    public void monitor(List<Sensor> sensors) {
        System.out.println("Monitoring...");
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

