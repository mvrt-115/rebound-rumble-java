package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Constants;
import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Controls the firing of the shooter
 * @author Lee Mracek
 *
 */
public class FireMotor extends Command {
	public FireMotor() {
		requires(Robot.shooter);
	}

	/**
	 * Sets the motor speed to max but checks for MotorSpeedException
	 */
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
		return false;
	}

	/**
	 * Prevents runaway motor disorder
	 */
	@Override
	protected void end() {
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
