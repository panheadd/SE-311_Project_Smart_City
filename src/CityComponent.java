import java.util.List;
import java.util.ArrayList;

//this is abstract component.
public interface CityComponent {
    public String getName();
    public void add(CityComponent c);
    public void remove(CityComponent c);
    public List<Sensor> getSensors();

}

class CityComposite implements CityComponent {
    private String name;
    private List<CityComponent> children;
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void add(CityComponent c) {
        if (c != null){
            children.add(c);
        }
    }
    @Override
    public void remove(CityComponent c) {
        children.remove(c);
    }
    @Override
    public List<Sensor> getSensors() {
        List<Sensor> all = new ArrayList<>();
        for (CityComponent c : children)
            all.addAll(c.getSensors());
        return all;
    }
    public CityComposite(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }

}
class CityLeaf implements CityComponent {
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