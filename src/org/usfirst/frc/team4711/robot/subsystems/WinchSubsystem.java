package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team4711.robot.config.MotorSpeeds;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

	private WPI_TalonSRX winch;
	
	private static WinchSubsystem instance;
	
	private WinchSubsystem() {
		super("climberSubsystem");
		
		winch = new WPI_TalonSRX(RobotMap.WINCH);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static WinchSubsystem getInstance(){
		if(instance == null)
			instance = new WinchSubsystem();
		
		return instance;
	}
	
	public void setMotorSpeed(double moveValue){
		if(DriverStation.getInstance().isOperatorControl()) 
			moveValue *= MotorSpeeds.TELEOP_MULTIPLIER;
		else
			moveValue *= MotorSpeeds.AUTONOMOUS_MULTIPLIER;
		
		winch.set(moveValue * MotorSpeeds.CLIMB_SPEED);
	}
}
