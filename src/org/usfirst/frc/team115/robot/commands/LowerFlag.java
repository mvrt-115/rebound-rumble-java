package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerFlag extends Command {
	public LowerFlag() {
		requires(Robot.flag);
	}

	@Override
	protected void initialize() {
		Robot.flag.set(Robot.flag.DOWN);
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
