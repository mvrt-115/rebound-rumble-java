package org.usfirst.frc.team115.reboundrumble.subsystems;

import org.usfirst.frc.team115.reboundrumble.RobotMap;
import org.usfirst.frc.team115.reboundrumble.commands.LowerFlag;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flag extends Subsystem {
	private DoubleSolenoid flag;
	public final boolean DOWN = false;
	public final boolean UP = true;
	
	public Flag() {
		super();
		flag = new DoubleSolenoid(RobotMap.FLAG_SOLENOID_1, RobotMap.FLAG_SOLENOID_2);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LowerFlag());
	}
	
	public void set(boolean state) {
		flag.set(state ? Value.kForward : Value.kReverse);
	}

}
