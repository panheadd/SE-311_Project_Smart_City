import java.util.List;

public interface CityComponent {
    public String getName();
    public void add(CityComponent c);
    public void remove(CityComponent c);
    public List<Sensor> getSensors();

}
