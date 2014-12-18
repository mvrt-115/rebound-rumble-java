package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseFlag extends Command {
	public RaiseFlag() {
		requires(Robot.flag);
	}

	@Override
	protected void initialize() {
		Robot.flag.set(Robot.flag.UP);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.flag.set(Robot.flag.DOWN);
	}

	@Override
	protected void interrupted() {}

}
