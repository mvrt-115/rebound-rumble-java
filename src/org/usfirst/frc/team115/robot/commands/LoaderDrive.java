package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Lee Mracek
 * Command to drive the loader
 */
public class LoaderDrive extends Command {
	
	/**
	 * Defines subsystems required by the command
	 */
	public LoaderDrive() {
		requires(Robot.loader);
	}
	
	@Override
	protected void initialize() {
	}

	/**
	 * Sets the motor to the throttle speed, and catches MotorSpeedException
	 */
	@Override
	protected void execute() {
		if (DriverStation.getInstance().getBatteryVoltage() < 8 && Robot.loader.getSpeed() != 0) {
			Robot.loader.stop();
		} else {
			try {
				Robot.loader.setSpeed(Robot.oi.getJoystick().getX());
			} catch (MotorSpeedException e) {
				end();
				e.printStackTrace();
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false; //runs until completion
	}

	//Prevent runaway robot disorder
	@Override
	protected void end() {
		Robot.loader.stop();;
	}

	@Override
	protected void interrupted() {
		end();
	}

}
