import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SensorFactory tempFac = new TemperatureSensorFactory();
        SensorFactory polFac = new PollutionSensorFactory();
        SensorFactory congFac = new CongestionSensorFactory();
        SensorFactory noiseFac = new NoiseSensorFactory();
        BuildSensor bs = new BuildSensor();
        List<Sensor> sensor = new ArrayList<>();
        sensor.add(bs.createSensor(tempFac));
        sensor.add(bs.createSensor(polFac));
        sensor.add(bs.createSensor(congFac));
        sensor.add(bs.createSensor(noiseFac));



        CityComponent city = new CityComposite("İzmir");
        CityComponent neighbourhood = new CityComposite("Balçova");
        CityComponent street = new CityComposite("Sokak");
        CityComponent apartment1 = new CityLeaf("Balçova da ki Apartman 1",new ArrayList<>(sensor));
        CityComponent apartment2 = new CityLeaf("Balçova da ki Apartman 2",new ArrayList<>(sensor));
        CityComponent pole1 = new CityLeaf("Balçova da direk",new ArrayList<>(sensor));
        CityComponent pole2 = new CityLeaf("sokak da direk 1",new ArrayList<>(sensor));
        CityComponent pole3 = new CityLeaf("sokak da direk 2",new ArrayList<>(sensor));
        street.add(pole2);
        street.add(pole3);
        neighbourhood.add(street);
        neighbourhood.add(pole1);
        neighbourhood.add(apartment1);
        neighbourhood.add(apartment2);
        city.add(neighbourhood);

        DataMonitoringDivision dmd = DataMonitoringDivision.getInstance();
        Engineer eng = new Engineer();
        dmd.monitor(city.getSensors());
        eng.resetSensors(city.getSensors());
    }
}