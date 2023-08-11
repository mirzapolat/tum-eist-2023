package de.tum.in.ase.pse.model;

import de.tum.in.ase.pse.view.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is representing a factory machine, which is the model inside the system.
 */
public abstract class Machine {

	protected List<Observer> observers;


	/**
	 * machine values
	 */
	private final String name;

	private final int minVoltage;
	private final int maxVoltage;
	private int targetVoltage;
	private int currentVoltage;

	private final int minTemperature;
	private final int maxTemperature;
	private int targetTemperature;
	private int currentTemperature;

	protected Machine(String name, int minVoltage, int maxVoltage, int targetVoltage, int minTemperature,
	                  int maxTemperature, int targetTemperature) {
		this.name = name;
		this.minVoltage = minVoltage;
		this.maxVoltage = maxVoltage;
		this.targetVoltage = targetVoltage;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.targetTemperature = targetTemperature;

		this.observers = new ArrayList<>();
	}

	public void addObserver(Observer observer) {
		if (!this.observers.contains(observer))
			this.observers.add(observer);
	}


	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}


	protected void notifyObservers() {
		for (Observer o : this.observers) {
			o.update(this);
		}
	}

	/**
	 * Standard setters for machine values, that can be changed/updated after instantiation.
	 * Further the setters notify the machine's observers.
	 * 1.4: TODO: Make sure that the observes get notified about all changes to the machine's parameters
	 */

	public void setTargetVoltage(int targetVoltage) {
		this.targetVoltage = targetVoltage;
		notifyObservers();
	}

	public void setCurrentVoltage(int currentVoltage) {
		this.currentVoltage = currentVoltage;
		notifyObservers();
	}

	public void setTargetTemperature(int targetTemperature) {
		this.targetTemperature = targetTemperature;
		notifyObservers();
	}

	public void setCurrentTemperature(int currentTemperature) {
		this.currentTemperature = currentTemperature;
		notifyObservers();
	}

	/**
	 * Standard getters for the machine values.
	 */

	public String getName() {
		return name;
	}

	public int getMinVoltage() {
		return minVoltage;
	}

	public int getMaxVoltage() {
		return maxVoltage;
	}

	public int getTargetVoltage() {
		return targetVoltage;
	}

	public int getCurrentVoltage() {
		return currentVoltage;
	}

	public int getMinTemperature() {
		return minTemperature;
	}

	public int getMaxTemperature() {
		return maxTemperature;
	}

	public int getTargetTemperature() {
		return targetTemperature;
	}

	public int getCurrentTemperature() {
		return currentTemperature;
	}
}

