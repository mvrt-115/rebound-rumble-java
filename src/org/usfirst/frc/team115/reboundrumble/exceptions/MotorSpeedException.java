package org.usfirst.frc.team115.reboundrumble.exceptions;

public class MotorSpeedException extends Exception {
	private static final long serialVersionUID = 7843672830611527699L;
	private final double speed;

	public MotorSpeedException (String err, double speed) {
		super(err + "\nSpeed of " + speed + " is not allowed!");
		this.speed = speed;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
	public double getSpeed() {
		return speed;
	}
}
