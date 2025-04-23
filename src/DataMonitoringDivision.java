import java.util.List;

public class DataMonitoringDivision {
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
