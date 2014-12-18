package org.usfirst.frc.team115.reboundrumble.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.reboundrumble.RobotMap;
import org.usfirst.frc.team115.reboundrumble.commands.LoaderDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends VBusMotorSystem {
	private CANTalon roller, elevator;
	
	public Loader() {
		super();
		roller = new CANTalon(RobotMap.ROLLER);
		elevator = new CANTalon(RobotMap.ELEVATOR);
		motors.add(roller);
		motors.add(elevator);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LoaderDrive());
	}

}