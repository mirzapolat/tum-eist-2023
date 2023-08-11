package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import de.tum.in.ase.pse.utils.FactoryException;

/**
 * The (terminal) controller superclass
 * This class and the corresponding buttons form the controller part of the system.
 * Actually this only delegates the calls. It was however implemented to mock a dedicated controller.
 */
public class MachineTerminal {

	private final Machine machine;

	public MachineTerminal(Machine machine) {
		this.machine = machine;
	}

	/**
	 * This method updates the target temperature of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. temperature of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetTemperature(int targetTemperature) {
		if (targetTemperature <= machine.getMaxTemperature() && targetTemperature >= machine.getMinTemperature())
			machine.setTargetTemperature(targetTemperature);
		else
			throw new FactoryException("Target Temperature out of bounds");
	}

	/**
	 * This method updates the target voltage of the machine (by using machine's setter).
	 * It checks if the input value is between the min. and the max. voltage of the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetVoltage(int targetVoltage) {
		if (targetVoltage <= machine.getMaxVoltage() && targetVoltage >= machine.getMinVoltage())
			machine.setTargetVoltage(targetVoltage);
		else
			throw new FactoryException("Target Voltage out of bounds");
	}
}
