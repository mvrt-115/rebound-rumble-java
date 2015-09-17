package org.usfirst.frc.team115.robot.commands;

import org.usfirst.frc.team115.lib.trajectory.TrajectoryFollower;
import org.usfirst.frc.team115.lib.trajectory.TrajectoryFollowingPositionController;
import org.usfirst.frc.team115.robot.Robot;
import org.usfirst.frc.team115.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TrajectoryTurnInPlace extends Command {

	private TrajectoryFollowingPositionController controller;
	private final double destHeading;

	public TrajectoryTurnInPlace(double destHeading, double velocity) {
		requires(Robot.drive);
		TrajectoryFollower.TrajectoryConfig config = new TrajectoryFollower.TrajectoryConfig();
	    config.dt = 20 / 1000;
	    config.maxAcceleration = RobotMap.TURN_MAX_ACCEL;
	    config.maxVelocity = velocity;
	    controller = new TrajectoryFollowingPositionController(
	            RobotMap.TURN_KP,
	            RobotMap.TURN_KI,
	            RobotMap.TURN_KD,
	            RobotMap.TURN_KV,
	            RobotMap.TURN_KA,
	            RobotMap.TURN_ON_TARGET_ERROR,
	            config);
	    
	    this.destHeading = destHeading;
	}

	@Override
	protected void initialize() {
		TrajectoryFollower.TrajectorySetpoint initialSetpoint = new TrajectoryFollower.TrajectorySetpoint();
	    initialSetpoint.position = Math.toRadians(Robot.navx.getAngle());
	    initialSetpoint.velocity = Math.toRadians(Robot.navx.getRate());
	    
	    controller.setGoal(initialSetpoint, destHeading);
	}

	@Override
	protected void execute() {
		controller.update(Robot.navx.getAngle(), Robot.navx.getRate());
		double turn = controller.get();
		Robot.drive.control(-turn, turn);
	}

	@Override
	protected boolean isFinished() {
		return controller.isFinishedTrajectory();
	}

	@Override
	protected void end() {
		Robot.drive.stop();
	}

	@Override
	protected void interrupted() {
		Robot.drive.stop();
	}
}
