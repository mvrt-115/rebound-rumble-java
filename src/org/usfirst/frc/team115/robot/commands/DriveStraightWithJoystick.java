package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightWithJoystick extends Command {
	
	private AnalogInput temp, gyro_vol;

	public DriveStraightWithJoystick() {
		requires(Robot.drive);
		temp = new AnalogInput(1);
	}
	
	private double temperature() {
		return temp.getVoltage();
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
	}

	@Override
	protected void execute() {
		Robot.drive.drive(Robot.oi.getJoystick().getY(), 0);
		SmartDashboard.putNumber("Rate", Robot.drive.getRate());
		SmartDashboard.putNumber("Angle", Robot.drive.getAngle());
		SmartDashboard.putNumber("Temp", temperature());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		Robot.drive.drive(0, 0);
	}

}
