package org.usfirst.frc.team115.robot;

import org.usfirst.frc.team115.robot.commands.FireMotor;
import org.usfirst.frc.team115.robot.commands.RaiseFlag;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick joystick;
	private JoystickButton triggerButton, flagButton;
	
	public OI() {
		joystick = new Joystick(RobotMap.JOYSTICK);
		triggerButton = new JoystickButton(joystick, RobotMap.SHOOT);
		flagButton = new JoystickButton(joystick, RobotMap.FLAG);
		
		//adds commands to run on various joystick actions
		triggerButton.toggleWhenPressed(new FireMotor());
		flagButton.toggleWhenPressed(new RaiseFlag());
	}

	public Joystick getJoystick() {
		return joystick;
	}

}

