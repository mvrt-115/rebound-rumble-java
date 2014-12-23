package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.command.Command;

public class LoaderDrive extends Command {
	
	public LoaderDrive() {
		requires(Robot.loader);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		try {
			Robot.loader.setSpeed(Robot.oi.getJoystick().getThrottle());
		} catch (MotorSpeedException e) {
			end();
			e.printStackTrace();
		}
	}

	@Override
	protected boolean isFinished() {
		return false; //runs until completion
	}

	@Override
	protected void end() {
		Robot.loader.stop();;
	}

	@Override
	protected void interrupted() {
		end();
	}

}
