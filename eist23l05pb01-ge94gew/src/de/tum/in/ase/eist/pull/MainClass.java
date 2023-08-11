package de.tum.in.ase.eist.pull;

public class MainClass {
    public static void main(String[] args) {
        // TODO: find the bug: why do the views show different information after the temperature update

        // Setup
        WeatherModel model = new WeatherModel();
        WeatherController controller = new WeatherController(model);
        WeatherMainView mainView = new WeatherMainView(controller, model);
        WeatherWidgetView widgetView = new WeatherWidgetView(controller, model);

        // Views are displaying the temperature
        System.out.println("\nThe temperature before updates:");
        mainView.display();
        widgetView.display();

        // Controller receives information about new temperature
        controller.handleNewTemperatureForecast(35);

        // Views are displaying the new temperature
        System.out.println("\nThe temperature after updates:");
        mainView.display();
        widgetView.display();
    }
}
