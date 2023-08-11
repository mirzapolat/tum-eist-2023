package de.tum.in.ase.eist.pull;

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
