package org.usfirst.frc.team115.robot.subsystems;

import org.usfirst.frc.team115.robot.commands.EnableCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorSystem extends Subsystem {
	private Compressor compressor;
	
	public CompressorSystem() {
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
	}
	
	public void disable() {
		compressor.stop();
	}
	
	public void enable() {
		compressor.start();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new EnableCompressor());
	}

}
