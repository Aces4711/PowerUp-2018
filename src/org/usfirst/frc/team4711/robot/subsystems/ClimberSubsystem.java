package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team4711.robot.config.MotorSpeeds;


import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {

	private WPI_TalonSRX climber;
	
	private static ClimberSubsystem instance;
	
	private ClimberSubsystem() {
		super("climberSubsystem");
		
		climber = new WPI_TalonSRX(RobotMap.LEFT_CLIMB_CHANNEL);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static ClimberSubsystem getInstance(){
		if(instance == null)
			instance = new ClimberSubsystem();
		
		return instance;
	}
	
	public void setMotorSpeed(double moveValue){
		climber.set(moveValue * MotorSpeeds.CLIMB_SPEED);
	}
}
