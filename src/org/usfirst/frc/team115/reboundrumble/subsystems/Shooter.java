package org.usfirst.frc.team115.reboundrumble.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team115.reboundrumble.Robot;
import org.usfirst.frc.team115.reboundrumble.RobotMap;
import org.usfirst.frc.team115.reboundrumble.commands.StopMotor;
import org.usfirst.frc.team115.reboundrumble.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends VBusMotorSystem {
	private CANTalon shooter1, shooter2;
	
	public Shooter() {
		super();
		shooter1 = new CANTalon(RobotMap.SHOOTER_1);
		shooter2 = new CANTalon(RobotMap.SHOOTER_2);
		motors.add(shooter1);
		motors.add(shooter2);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new StopMotor());
	}

}
