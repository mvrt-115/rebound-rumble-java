package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Constants;
import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.RobotMap;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the firing of the shooter
 * @author Lee Mracek
 *
 */
public class FireMotor extends Command {
	public FireMotor() {
		requires(Robot.shooter);
	}

	/**
	 * Sets the motor speed to max but checks for MotorSpeedException
	 */
	@Override
	protected void initialize() {
		try {
			//double speed = Preferences.getInstance().getDouble("ShooterSpeed", Constants.SHOOTER_MAX);
			//Robot.shooter.setSpeed(Constants.SHOOTER_MAX);
			if(Robot.oi.getJoystick().getRawButton(RobotMap.SHOOT_FAST))
				Robot.shooter.setSpeed(Constants.SHOOTER_MAX - 0.3); 
			else if(Robot.oi.getJoystick().getRawButton(RobotMap.SHOOT_SLOW))
				Robot.shooter.setSpeed(Constants.SHOOTER_MAX - 0.5);
			else
				Robot.shooter.setSpeed(Constants.SHOOTER_MAX);
			SmartDashboard.putNumber("shooter_speed", Robot.shooter.getSpeed());
		} catch (MotorSpeedException e) {
			Robot.shooter.stop();
			e.printStackTrace();
		}
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Prevents runaway motor disorder
	 */
	@Override
	protected void end() {
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
