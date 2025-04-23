import java.util.ArrayList;
import java.util.List;

public class CityComposite implements CityComponent {
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
