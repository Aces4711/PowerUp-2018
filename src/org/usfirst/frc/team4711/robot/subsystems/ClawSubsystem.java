package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.commands.DriveWithController;
import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClawSubsystem extends Subsystem {
	
	private WPI_TalonSRX LCMotor, RCMotor;
	
	private static ClawSubsystem instance;
	
	private ClawSubsystem() {
		super("clawSubsystem");
		
		LCMotor = new WPI_TalonSRX(RobotMap.LCTalon);
		RCMotor = new WPI_TalonSRX(RobotMap.RCTalon);
	}
	
	public static ClawSubsystem getInstance(){
		if(instance == null)
			instance = new ClawSubsystem();
		
		return instance;
	}
	
	public void stop() {
		LCMotor.stopMotor();
		RCMotor.stopMotor();
	}
	

	/**
	 * Positive move values intake; negative values eject
	 * @param moveValue
	 */
	public void setMotorSpeed(double moveValue){
		LCMotor.set(moveValue * MotorSpeeds.CLAW_SPEED);
		RCMotor.set(moveValue * MotorSpeeds.CLAW_SPEED * -1);
	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveWithController());

	}

}
