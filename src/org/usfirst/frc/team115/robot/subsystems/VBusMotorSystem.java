package org.usfirst.frc.team115.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * @author Lee Mracek
 * This class serves as an abstraction of systems involving multiple motors run
 * in parallel and controlled by VBus. Other classes extend this class.
 */

public abstract class VBusMotorSystem extends Subsystem {
	
	/* 
	* motors is an ArrayList that contains all the motors in the system. These are
	* added by the subclass.
	*/
	protected ArrayList<Talon> motors = new ArrayList<Talon>();
	private double speed;
	protected boolean invert;
	
	/**
	 * This method stops all the motors in the array by iterating through them
	 * and setting their speeds to 0.
	 */
	public void stop() {
		for (Talon motor : motors) {
			motor.set(0);
		}
	}
	
	/**
	 * Sets the speed of all the motors by iterating through and setting them.
	 * @param speed
	 * @throws MotorSpeedException
	 */
	public void setSpeed(double speed) throws MotorSpeedException {
		this.speed = speed; // sets the speed of the system
		// checks if the speed is within acceptable VBus range.
		if (Math.abs(speed) <= 1) {
			for (Talon motor : motors) {
				// sets each motor. If the output is inverted, multiplies by -1.
				motor.set((invert ? -1 : 1) * this.speed);
			}
		} else {
			// throws a custom exception if the speed is not acceptable.
			throw new MotorSpeedException("Shooter speed cannot be "
					+ "greater than 1 or less than -1", speed);
		}
	}
	
	/**
	 * Getter for motor speed
	 * @return The speed of the motor system
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Sets whether the system is inverted
	 * @param invert
	 */
	public void setInverted(boolean invert) {
		this.invert = invert;
	}
	
	/**
	 * @return Whether the system is inverted
	 */
	public boolean isInverted() {
		return invert;
	}

}