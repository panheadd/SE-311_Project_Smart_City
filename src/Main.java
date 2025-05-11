import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Observer> observersInApartment1 = new ArrayList<>();
        Citizen c0 = new Citizen("Citizen 1");
        Citizen c1 = new Citizen("Citizen 2");
        observersInApartment1.add(c0);
        observersInApartment1.add(c1);

        List<Observer> observersInApartment2 = new ArrayList<>();
        Citizen c3 = new Citizen("Citizen 3");
        observersInApartment2.add(c3);

        Citizen c4 = new Citizen("Citizen 4");


        SensorFactory tempFac = new TemperatureSensorFactory();
        SensorFactory polFac = new PollutionSensorFactory();
        SensorFactory congFac = new CongestionSensorFactory();
        SensorFactory noiseFac = new NoiseSensorFactory();
        BuildSensor bs = new BuildSensor();
        List<Sensor> sensorsOnApartment1 = new ArrayList<>();

        sensorsOnApartment1.add(bs.createSensor(tempFac,"Temperature Sensor in Apartment 1",observersInApartment1));
        sensorsOnApartment1.add(bs.createSensor(polFac,"Pollution Sensor in Apartment 1",observersInApartment1));
        sensorsOnApartment1.add(bs.createSensor(congFac,"Congestion Sensor in Apartment 1",observersInApartment1));
        sensorsOnApartment1.add(bs.createSensor(noiseFac,"Noise Sensor in Apartment 1",observersInApartment1));

        sensorsOnApartment1.get(0).setValue(-10);
        sensorsOnApartment1.get(1).setValue(1000);
        sensorsOnApartment1.get(2).setValue(1);
        sensorsOnApartment1.get(3).setValue(100);

        List<Sensor> sensorsOnApartment2 = new ArrayList<>();
        sensorsOnApartment2.add(bs.createSensor(tempFac,"Temperature Sensor in Apartment 2",observersInApartment2));
        sensorsOnApartment2.add(bs.createSensor(polFac,"Pollution Sensor in Apartment 2",observersInApartment2));
        sensorsOnApartment2.add(bs.createSensor(congFac,"Congestion Sensor in Apartment 2",observersInApartment2));
        sensorsOnApartment2.add(bs.createSensor(noiseFac,"Noise Sensor in Apartment 2",observersInApartment2));

        sensorsOnApartment2.get(0).setValue(-5);
        sensorsOnApartment2.get(1).setValue(500);
        sensorsOnApartment2.get(2).setValue(0);
        sensorsOnApartment2.get(3).setValue(110);

        Sensor ts =  bs.createSensor(tempFac,"Temperature Sensor on Pole in Balçova");
        Sensor ps =  bs.createSensor(polFac,"Pollution Sensor on Pole 1 in Street");
        Sensor cs =  bs.createSensor(congFac,"Congestion Sensor on Pole 2 in Street");

        ts.attach(c4);
        ps.attach(c4);
        cs.attach(c4);

        ts.setValue(-17);
        ps.setValue(300);
        cs.setValue(4);


        CityComponent city = new CityComposite("İzmir");
        CityComponent neighbourhood = new CityComposite("Balçova");
        CityComponent street = new CityComposite("Street in Balçova");
        CityComponent apartment1 = new CityLeaf("Apartment 1 in Balçova",sensorsOnApartment1);
        CityComponent apartment2 = new CityLeaf("Apartment 2 in Balçova",sensorsOnApartment2);
        CityLeaf pole1 = new CityLeaf("Pole in Balçova");
        CityLeaf pole2 = new CityLeaf("Pole 1 in Street");
        CityLeaf pole3 = new CityLeaf("Pole 2 in Street");

        pole1.addSensor(ts);
        pole1.addSensor(ps);
        pole1.addSensor(cs);

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