package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class drives the robot forward for a time.
 * @author Lee Mracek
 *
 */
public class DriveStraight extends Command {
	
	/**
	 * Default constructor!
	 */
	public DriveStraight() {
		this(1); // default timeout is 1, dammit
	}
	
	/**
	 * Constructor sets requirement and adds timeout
	 * @param timeout
	 */
	public DriveStraight(double timeout) {
		requires(Robot.drive);
		setTimeout(timeout);
	}

	/**
	 * Resets the encoders, etc to get accurate driving
	 */
	@Override
	protected void initialize() {
		Robot.drive.reset();
	}

	/**
	 * Drives the robot forwards with equal power in each motor
	 */
	@Override
	protected void execute() {
		double speed = Robot.oi.getJoystick().getY();
		Robot.drive.drive(speed, speed);
		// TODO add gyro
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	/**
	 * Stops the robot when the command ends
	 */
	@Override
	protected void end() {
		Robot.drive.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
	// TODO add gyro
}
