package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ClawSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class EjectCommand extends Command {
	
	private ClawSubsystem clawSubsystem;
	
	private double motorSpeed;
	
	public EjectCommand(double motorSpeed) {
		super("ejectCommand");
		this.motorSpeed = motorSpeed;
		
		clawSubsystem = ClawSubsystem.getInstance();
		requires(clawSubsystem);
		
		setTimeout((motorSpeed <= 0) ? 1 : 30);
	}
	
	@Override
	protected void initialize() {
		clawSubsystem.setMotorSpeed(motorSpeed);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}