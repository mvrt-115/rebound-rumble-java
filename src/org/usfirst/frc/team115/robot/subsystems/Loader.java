package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.LoaderDrive;

import edu.wpi.first.wpilibj.CANTalon;

public class Loader extends VBusMotorSystem {
	private CANTalon roller, elevator;
	
	//initializes the motors and adds them to the ArrayList
	public Loader() {
		super();
		roller = new CANTalon(RobotMap.ROLLER);
		elevator = new CANTalon(RobotMap.ELEVATOR);
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