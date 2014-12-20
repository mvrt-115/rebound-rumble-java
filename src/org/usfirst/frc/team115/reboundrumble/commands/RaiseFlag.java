package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseFlag extends Command {
	boolean timeout = true;
	
	public RaiseFlag() {
		requires(Robot.flag);
		timeout = false;
	}
	
	public RaiseFlag(double timeout) {
		requires(Robot.flag);
		setTimeout(timeout);
	}

	@Override
	protected void initialize() {
		Robot.flag.set(Robot.flag.UP);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return timeout ? isTimedOut() : false;
	}

	@Override
	protected void end() {
		Robot.flag.set(Robot.flag.DOWN);
	}

	@Override
	protected void interrupted() {}

}
