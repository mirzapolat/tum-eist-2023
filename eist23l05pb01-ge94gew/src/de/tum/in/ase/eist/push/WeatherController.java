package de.tum.in.ase.eist.push;

final public class WeatherController {
    private final WeatherModel model;

    public WeatherController(WeatherModel model) {
        this.model = model;
    }

    public void handleNewTemperatureForecast(int temperature) {
        model.setTemperature(temperature);
        model.notifyObservers();
    }
}
