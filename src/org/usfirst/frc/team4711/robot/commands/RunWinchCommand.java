package org.usfirst.frc.team4711.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4711.robot.subsystems.WinchSubsystem;

public class RunWinchCommand extends Command {
        
    	private WinchSubsystem winchSubsystem;
    	
    	private double motorSpeed;
    	
    	public RunWinchCommand(double motorSpeed) {
    		super("winchSubsystem");
    		this.motorSpeed = motorSpeed;
    		
    		winchSubsystem = WinchSubsystem.getInstance();
    		requires(winchSubsystem);
    		
    		setTimeout((motorSpeed <= 0) ? 1 : 6);
    	}
    	
    	@Override
    	protected void initialize() {
    		winchSubsystem.setMotorSpeed(motorSpeed);
    	}
    	
    	@Override
    	protected boolean isFinished() {
    		return isTimedOut();
    	}
    	
    	@Override
        protected void end() {
    		winchSubsystem.setMotorSpeed(0.0);
        }
    	
    	@Override
    	protected void interrupted() {
    		end();
    	}

    }