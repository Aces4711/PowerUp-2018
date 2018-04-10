package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ClawSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class ClawCommand extends Command {
	
	private ClawSubsystem clawSubsystem;
	
	private double motorSpeed;
	
	public ClawCommand(double motorSpeed) {
		super("clawSubsystem");
		this.motorSpeed = motorSpeed;
		
		clawSubsystem = ClawSubsystem.getInstance();
		requires(clawSubsystem);
		
		setTimeout((motorSpeed <= 0) ? 1 : 6);
	}
	
	@Override
	protected void initialize() {
	   	execute();
	}
	
    protected void execute() {
    	clawSubsystem.setMotorSpeed(motorSpeed);
    }
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
    protected void end() {
		clawSubsystem.setMotorSpeed(0.0);
    }
	
	@Override
	protected void interrupted() {
		end();
	}

}