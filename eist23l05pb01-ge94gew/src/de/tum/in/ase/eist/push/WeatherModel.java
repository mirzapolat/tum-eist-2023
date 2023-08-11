package de.tum.in.ase.eist.push;

import java.util.ArrayList;
import java.util.List;

final public class WeatherModel {
    private int temperature;

    private List<Observer> observers;

    public WeatherModel() {
        observers = new ArrayList<>();
        this.temperature = 42;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
        observer.update(temperature);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void notifyObservers() {
        for (Observer o : observers)
                o.update(this.temperature);
    }
}
