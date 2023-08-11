package de.tum.in.ase.eist.pull;

import java.util.ArrayList;
import java.util.List;

final public class WeatherModel {
    private int temperature;
    private final List<Observer> observers;

    public WeatherModel() {
        this.observers = new ArrayList<>();
        this.temperature = 20;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
