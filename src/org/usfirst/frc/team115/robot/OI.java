package org.usfirst.frc.team115.robot;

import org.usfirst.frc.team115.robot.commands.ArcadeDriveWithJoystick;
import org.usfirst.frc.team115.robot.commands.FireMotor;
import org.usfirst.frc.team115.robot.commands.StopMotor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * @author Akhil Palla
 */
public class OI {
	private Joystick joystick;
	private JoystickButton triggerButton, flagButton, straightToggle;
	
	public OI() {
		joystick = new Joystick(RobotMap.JOYSTICK);
		triggerButton = new JoystickButton(joystick, RobotMap.SHOOT);
		flagButton = new JoystickButton(joystick, RobotMap.FLAG);
		straightToggle = new JoystickButton(joystick, RobotMap.TURN);
		// add triggers
		
		triggerButton.whenPressed(new FireMotor());
		triggerButton.whenReleased(new StopMotor());
		straightToggle.toggleWhenPressed(new ArcadeDriveWithJoystick(true));
		//flagButton.toggleWhenPressed(new RaiseFlag());
	}

	public Joystick getJoystick() {
		return joystick;
	}

}

