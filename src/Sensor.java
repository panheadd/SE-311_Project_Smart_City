import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Sensor {
    protected String name;
    protected boolean malfunctioning;
    protected List<Observer> observers;

    public void attach(Observer observer){
        this.observers.add(observer);
    }
    public void detach(Observer observer){
        for (int i = 0; i< observers.size(); i++) {
            if (Objects.equals(observers.get(i).getName(), observer.getName())) {
                observers.remove(i);
                return;
            }
        }
    }
    public void Notify(String message) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this,message);
        }
    }
    public abstract void checkStatus();
    public abstract void reset();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMalfunctioning() {
        return this.malfunctioning;
    }

    public void setMalfunctioning(boolean malfunctioning) {
        this.malfunctioning = malfunctioning;
    }

    public Sensor(String name){
        this.name = name;
        this.malfunctioning = false;
        this.observers = new ArrayList<>();
    }
    public Sensor(String name,List<Observer> observers){
        this.name = name;
        this.malfunctioning = false;
        this.observers = observers;
    }

}
