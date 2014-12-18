package org.usfirst.frc.team115.reboundrumble.subsystems;

import org.usfirst.frc.team115.reboundrumble.RobotMap;
import org.usfirst.frc.team115.reboundrumble.commands.StopMotor;

import edu.wpi.first.wpilibj.CANTalon;

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
