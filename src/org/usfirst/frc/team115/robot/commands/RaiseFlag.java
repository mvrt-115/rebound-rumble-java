package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Lee Mracek
 * Command deals with the command toggling
 */
public class RaiseFlag extends Command {
	boolean timeout = true; // specify if we need to set a timeout
	
	/**
	 * Default constructor does not set timeout
	 */
	public RaiseFlag() {
		requires(Robot.flag);
		timeout = false;
	}
	
	/**
	 * Constructor with double sets timeout to equal the double. Used to specify a duration of the command
	 * @param timeout
	 */
	public RaiseFlag(double timeout) {
		requires(Robot.flag);
		setTimeout(timeout);
	}

	/**
	 * Method that is called before the command executes
	 */
	@Override
	protected void initialize() {
		Robot.flag.set(Robot.flag.UP);
	}

	/**
	 * Called while command is running. Blank because we don't want it to do anything
	 */
	@Override
	protected void execute() {}

	/**
	 * Either returns if it has timed out or false based on whether timeout is set.
	 */
	@Override
	protected boolean isFinished() {
		return timeout ? isTimedOut() : false;
	}

	/**
	 * Called when the command ends
	 */
	@Override
	protected void end() {
		Robot.flag.set(Robot.flag.DOWN); //sets the flag to down
	}

	/**
	 * Called when the command is interrupted
	 */
	@Override
	protected void interrupted() {}

}
