package org.usfirst.frc.team115.robot.exceptions;

/**
 * @author Lee Mracek
 * This class is a custom exception that is specifically designed for motor speed values
 */
public class MotorSpeedException extends Exception {
	private static final long serialVersionUID = 7843672830611527699L; //serialVersionUID because exceptions are serializable
	private final double speed;
	
	/**
	 * Calls the super constructor to generate a custom error message based on the speed.
	 * @param err
	 * @param speed
	 */
	public MotorSpeedException (String err, double speed) {
		super(err + "\nSpeed of " + speed + " is not allowed!!");
		this.speed = speed;
	}
	
	/**
	 * Returns the error message
	 */
	public String getMessage() {
		return super.getMessage();
	}
	
	/**
	 * @return The speed of the error
	 */
	public double getSpeed() {
		return speed;
	}
}
