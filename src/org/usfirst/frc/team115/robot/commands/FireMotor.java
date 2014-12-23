package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Constants;
import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

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
