package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Lee Mracek
 * This command stops the shooter motor
 */
public class StopMotor extends Command {
	
	/**
	 * Specifies the required subsystem
	 */
	public StopMotor() {
		requires(Robot.shooter);
	}

	/**
	 * Method is called right when the command is executed
	 */
	@Override
	protected void initialize() {
		Robot.shooter.stop();
	}
	
	/**
	 * Method is called in a loop while the command executes
	 */
	@Override
	protected void execute() {}
	
	/**
	 * Method checks if the command is finished
	 */
	@Override
	protected boolean isFinished() {
		return true; //returns true because we only care about initialization.
	}
	
	/**
	 * Called when the command is ended
	 */
	@Override
	protected void end() {}

	/**
	 * Called when the command is interrupted
	 */
	@Override
	protected void interrupted() {}

}
