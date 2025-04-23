import java.util.List;

public class Engineer {
    private CommandExecutor executor = new CommandExecutor();

    public void resetSensors(List<Sensor> sensors){
        for (Sensor s : sensors) {
            executor.runCommand(new ResetCommand(s));
        }
    }
}
