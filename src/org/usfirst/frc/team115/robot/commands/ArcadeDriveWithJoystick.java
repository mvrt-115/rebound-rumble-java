package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to drive the robot using the joystick.
 * @author Lee Mracek
 *
 */
public class ArcadeDriveWithJoystick extends Command {
	
	public ArcadeDriveWithJoystick() {
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
	}

	/**
	 * Drives the robot based on a joystick
	 */
	@Override
	protected void execute() {
		Robot.drive.drive(Robot.oi.getJoystick());
	}

	@Override
	protected boolean isFinished() {
		return false; //run until interrupted
	}

	/**
	 * Stops the drivetrain when the command ends
	 */
	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		Robot.drive.drive(0, 0);
	}

}
