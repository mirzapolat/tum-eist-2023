package de.tum.in.ase.eist.pull;

import java.util.Random;

public final class WeatherMainView implements Observer {

    private final WeatherController controller;
    private final WeatherModel model;
    private int temperature;
    private boolean updated;

    public WeatherMainView(WeatherController controller, WeatherModel model) {
        this.controller = controller;
        this.model = model;
        this.temperature = model.getTemperature();
        // At the beginning we don't know the value, because we've never pulled it
        this.updated = false;
        // Subscribes the view to the updates from the model
        model.addObserver(this);
    }

    public void display() {
        // If there was an update and we need to display the temperature, we pull it from the model
        if (this.updated) {
            this.temperature = model.getTemperature();
            this.updated = false;
        }
        
        System.out.printf("The temperature at main view now is %d.\n", temperature);
    }

    public void update() {
        updated = true;
    }
}
