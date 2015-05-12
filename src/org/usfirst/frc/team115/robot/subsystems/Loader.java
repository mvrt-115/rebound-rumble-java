package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.LoaderDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;

public class Loader extends VBusMotorSystem {
	private Talon roller, elevator;
	
	// initializes the motors and adds them to the ArrayList
	public Loader() {
		super();
		roller = new Talon(RobotMap.ROLLER);
		elevator = new Talon(RobotMap.ELEVATOR);
		motors.add(roller);
		motors.add(elevator);
	}
	
	/**
	 * Initializes the default command of the subsystem.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LoaderDrive());
	}

}