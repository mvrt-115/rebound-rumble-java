package org.usfirst.frc.team115.robot;

import org.usfirst.frc.team115.robot.commands.DisableCompressor;
import org.usfirst.frc.team115.robot.commands.DriveStraightWithJoystick;
import org.usfirst.frc.team115.robot.commands.EnableCompressor;
import org.usfirst.frc.team115.robot.commands.FireMotor;
import org.usfirst.frc.team115.robot.commands.RaiseFlag;
import org.usfirst.frc.team115.robot.commands.StopMotor;
import org.usfirst.frc.team115.robot.triggers.CompressorTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joystick;
	private JoystickButton triggerButton, flagButton, straightButton;
	private CompressorTrigger disableCompTrigger = new CompressorTrigger();
	
	public OI() {
		joystick = new Joystick(RobotMap.JOYSTICK);
		triggerButton = new JoystickButton(joystick, RobotMap.SHOOT);
		flagButton = new JoystickButton(joystick, RobotMap.FLAG);
		straightButton = new JoystickButton(joystick, RobotMap.STRAIGHT);
		
		//add triggers
		triggerButton.whenPressed(new FireMotor());
		triggerButton.whenReleased(new StopMotor());
		flagButton.toggleWhenPressed(new RaiseFlag());
		straightButton.toggleWhenPressed(new DriveStraightWithJoystick());
		
		disableCompTrigger.whenActive(new DisableCompressor());
		disableCompTrigger.whenInactive(new EnableCompressor());
	}

	public Joystick getJoystick() {
		return joystick;
	}

}

