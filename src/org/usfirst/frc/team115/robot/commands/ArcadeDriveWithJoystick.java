package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveWithJoystick extends Command {

	@Override
	protected void initialize() {
		requires(Robot.drive);
	}

	@Override
	protected void execute() {
		Robot.drive.drive(Robot.oi.getJoystick());
	}

	@Override
	protected boolean isFinished() {
		return false; //run until interrupted
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
