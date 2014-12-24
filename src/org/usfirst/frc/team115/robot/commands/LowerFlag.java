package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Lee Mracek
 * This class purely lowers the flag
 */
public class LowerFlag extends Command {
	/**
	 * Specifies required subsystem
	 */
	public LowerFlag() {
		requires(Robot.flag);
	}
	
	/**
	 * Sets the flag to down
	 */
	@Override
	protected void initialize() {
		Robot.flag.set(Robot.flag.DOWN);
	}

	@Override
	protected void execute() {}

	/**
	 * Command is instantly finished
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
