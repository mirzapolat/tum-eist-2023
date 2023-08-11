package de.tum.in.ase.eist.push;

public class WeatherWidgetView implements Observer {

    private final WeatherController controller;
    private final WeatherModel model;

    private int temperature;

    public WeatherWidgetView(WeatherController controller, WeatherModel model) {
        this.controller = controller;
        this.model = model;
        model.addObserver(this);
    }

    public void display() {
        System.out.println("Temperature is " + temperature);
    }

    public void update(final int temperature) {
        this.temperature = temperature;
    }
}
