package de.tum.in.ase.eist;

public final class App {

	private App() {
	}

	public static void main(String[] args) {
		// TODO 4: Make sure to use the Configurator to configure the loggers root level

		//This is a workaround for a known issue when starting JavaFX applications 
		UniversityApp.startApp(args);
	}
}
