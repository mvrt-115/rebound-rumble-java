package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.robot.Constants;
import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.exceptions.MotorSpeedException;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the firing of the shooter
 * @author Lee Mracek
 *
 */
public class FireMotor extends PIDCommand {
	private static final double kP, kI, kD;
	public FireMotor() {
		super(kP, kI, kD);
		requires(Robot.shooter);
	}

	/**
	 * Sets the motor speed to max but checks for MotorSpeedException
	 */
	@Override
	protected void initialize() {
		try {
			double speed = Preferences.getInstance().getDouble("ShooterSpeed", Constants.SHOOTER_MAX); 
			Robot.shooter.setSpeed(speed);
			SmartDashboard.putNumber("shooter_speed", Robot.shooter.getSpeed());
		} catch (MotorSpeedException e) {
			Robot.shooter.stop();
			e.printStackTrace();
		}
		getPIDController().setOutputRange(-1,1);
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

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

}


