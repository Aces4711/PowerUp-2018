package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.subsystems.ClawSubsystem;
import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class AutoClaw extends Command {
	
	private ClawSubsystem clawSubsystem;
	
	private double motorSpeed;

    public AutoClaw(double motorSpeed) {
    	super("clawSubsystem");
    	
		this.motorSpeed = motorSpeed;
		
		clawSubsystem = ClawSubsystem.getInstance();
		requires(clawSubsystem);
		
		setTimeout((motorSpeed <= 0) ? 1 : 6);
	}

    protected void initialize() {
    	clawSubsystem.setMotorSpeed(motorSpeed);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	clawSubsystem.setMotorSpeed(0.0);
    }

    protected void interrupted() {
    	end();
    }
}
