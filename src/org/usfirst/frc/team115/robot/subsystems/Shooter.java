package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.StopMotor;

import edu.wpi.first.wpilibj.CANTalon;

public class Shooter extends VBusMotorSystem {
	private CANTalon shooter1, shooter2;
	
	// Initializes the motors and adds them to the ArrayList.
	public Shooter() {
		super();
		shooter1 = new CANTalon(RobotMap.SHOOTER_1);
		shooter2 = new CANTalon(RobotMap.SHOOTER_2);
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
