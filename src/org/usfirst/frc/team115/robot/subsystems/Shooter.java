package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.StopMotor;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;

public class Shooter extends VBusMotorSystem {
	private Talon shooter1, shooter2;
	
	// Initializes the motors and adds them to the ArrayList.
	public Shooter() {
		super();
		shooter1 = new Talon(RobotMap.SHOOTER_1);
		shooter2 = new Talon(RobotMap.SHOOTER_2);
		motors.add(shooter1);
		motors.add(shooter2);
		
		invert = true; //inverts the motor output
	}
	
	/**
	 * Initializes the default command of the subsystem
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new StopMotor());
	}
}
