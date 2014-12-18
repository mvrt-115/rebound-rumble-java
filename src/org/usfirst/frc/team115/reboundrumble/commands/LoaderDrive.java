package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Robot;
import org.usfirst.frc.team115.reboundrumble.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.command.Command;

public class LoaderDrive extends Command {

	@Override
	protected void initialize() {
		requires(Robot.loader);
	}

	@Override
	protected void execute() {
		try {
			Robot.loader.setSpeed(Robot.oi.getJoystick().getX());
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
