package org.usfirst.frc.team115.robot.triggers;

import org.usfirst.frc.team115.robot.Constants;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * @author Lee Mracek
 * This class creates a trigger that runs when the battery voltage drops below 9 V.
 */
public class CompressorTrigger extends Trigger {

	@Override
	public boolean get() {
		return DriverStation.getInstance().getBatteryVoltage() < Constants.COMPRESSOR_BROWN;
	}
}
