package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to drive the robot using the joystick.
 * @author Lee Mracek
 *
 */
public class ArcadeDriveWithJoystick extends Command {
	
	private boolean turn;
	
	public ArcadeDriveWithJoystick() {
		requires(Robot.drive);
	}
	
	public ArcadeDriveWithJoystick(boolean turn){
		requires(Robot.drive);
		this.turn = turn;
	}

	@Override
	protected void initialize() {
	}

	/**
	 * Drives the robot based on a joystick
	 */
	@Override
	protected void execute() {
		Robot.drive.drive(Robot.oi.getJoystick(), turn);
	}

	@Override
	protected boolean isFinished() {
		return false; // run until interrupted
	}

	/**
	 * Stops the drivetrain when the command ends
	 */
	@Override
	protected void end() {
		Robot.drive.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
