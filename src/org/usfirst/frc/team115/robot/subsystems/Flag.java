package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.commands.LowerFlag;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flag extends Subsystem {
	private DoubleSolenoid flag;
	public final boolean DOWN = false; // constants that define boolean values for states of the solenoid
	public final boolean UP = true;
	
	public Flag() {
		super();
		//flag = new DoubleSolenoid(RobotMap.FLAG_SOLENOID_1, RobotMap.FLAG_SOLENOID_2); //initializes the double solenoid with two ports
	}
	
	/**
	 * Sets the state of the solenoid
	 * @param state
	 */
	public void set(boolean state) {
		//flag.set(state ? Value.kForward : Value.kReverse); //ternary operator between forward and reverse
	}
	
	/**
	 * Sets the default command of the subsystem
	 */
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new LowerFlag());
	}

}
