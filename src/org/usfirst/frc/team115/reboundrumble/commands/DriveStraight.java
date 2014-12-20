package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
	public DriveStraight(double timeout) {
		requires(Robot.drive);
		setTimeout(timeout);
	}

	@Override
	protected void initialize() {
		Robot.drive.reset();
	}

	@Override
	protected void execute() {
		Robot.drive.drive(1, 1);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drive.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
