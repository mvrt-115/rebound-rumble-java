package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Constants;
import org.usfirst.frc.team115.reboundrumble.Robot;
import org.usfirst.frc.team115.reboundrumble.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.command.Command;

public class FireMotor extends Command {
	public FireMotor() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		try {
			Robot.shooter.setSpeed(Constants.SHOOTER_MAX);
		} catch (MotorSpeedException e) {
			Robot.shooter.stop();
			e.printStackTrace();
		}
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
