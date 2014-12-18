package org.usfirst.frc.team115.reboundrumble.commands;

import org.usfirst.frc.team115.reboundrumble.Robot;
import org.usfirst.frc.team115.reboundrumble.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.command.Command;

public class StopMotor extends Command {
	
	public StopMotor() {
		requires(Robot.shooter);
	}

	@Override
	protected void initialize() {
		Robot.shooter.stop();
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
