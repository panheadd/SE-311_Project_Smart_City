import java.util.ArrayList;
import java.util.List;

public class CityLeaf implements CityComponent {
    private String name;
    private List<Sensor> sensors;
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(CityComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(CityComponent c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Sensor> getSensors() {
        return this.sensors;
    }

    public void addSensor(Sensor sensor){
        if (sensor != null){
            this.sensors.add(sensor);
        }
    }
    public CityLeaf(String name) {
        this.name = name;
        this.sensors = new ArrayList<>();
    }
    public CityLeaf(String name,List<Sensor> sensors){
        this.name = name;
        this.sensors = sensors;
    }
}