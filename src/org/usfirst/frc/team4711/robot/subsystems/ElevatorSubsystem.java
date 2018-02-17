package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
	private WPI_TalonSRX EMotor;
	
	private static ElevatorSubsystem instance;
	
	private ElevatorSubsystem () {
		super("elevatorSubsystem");
		
		EMotor = new WPI_TalonSRX(RobotMap.ETalon);
	}
	
	public static ElevatorSubsystem getInstance(){
		if(instance == null)
			instance = new ElevatorSubsystem();
		
		return instance;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void setMotorSpeed(double moveValue){
		EMotor.set(moveValue * MotorSpeeds.CLIMB_SPEED);
	}
}
