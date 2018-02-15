package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends Subsystem {
	private WPI_TalonSRX FLMotor, FRMotor, BRMotor, BLMotor;
	//DifferentialDrive drive = new DifferentialDrive(new WPI_TalonSRX(0), new WPI_TalonSRX(1));
	//Drive drive = new Drive(FLMotor, FRMotor, BLMotor, BRMotor);
	private DifferentialDrive wheels;
	
	private static DriveTrain instance;

	private DriveTrain() {
		super("driveSubsystem");
		
		FLMotor = new WPI_TalonSRX(RobotMap.FLTalon);
		FRMotor = new WPI_TalonSRX(RobotMap.FRTalon);
		BLMotor = new WPI_TalonSRX(RobotMap.BLTalon);
		BRMotor = new WPI_TalonSRX(RobotMap.BRTalon);
	
	    SpeedControllerGroup m_left = new SpeedControllerGroup(FLMotor, BLMotor);
		SpeedControllerGroup m_right = new SpeedControllerGroup(FRMotor, BRMotor);

		wheels = new DifferentialDrive(m_left, m_right);
		
	}
	
	public static DriveTrain getInstance(){
		if(instance == null)
			instance = new DriveTrain();
		
		return instance;
	}
	
	public void arcadeDrive(double moveValue, double rotateValue){
		wheels.arcadeDrive(moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL, rotateValue * MotorSpeeds.DRIVE_SPEED_TURN);
	}	
	
	public void stop(){
		wheels.stopMotor();
	}
	
	/*
	public void driveStraight(double moveValue){
		double leftMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL;
		double rightMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL;
		
		if(Math.abs(frontLeftWithEncoder.getSpeed()) > Math.abs(frontRightWithEncoder.getSpeed()))
			leftMoveValue *= Math.abs(frontRightWithEncoder.getSpeed() / frontLeftWithEncoder.getSpeed());
		else if(Math.abs(frontLeftWithEncoder.getSpeed()) < Math.abs(frontRightWithEncoder.getSpeed()))
			rightMoveValue *= Math.abs(frontLeftWithEncoder.getSpeed() / frontRightWithEncoder.getSpeed());
		
		wheels.tankDrive(leftMoveValue, rightMoveValue);
	}
	
	public void turnOnAxis(double moveValue) {
		double leftMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_TURN;
		double rightMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_TURN;
		
		if(Math.abs(frontLeftWithEncoder.getSpeed()) > Math.abs(frontRightWithEncoder.getSpeed()))
			leftMoveValue *= Math.abs(frontRightWithEncoder.getSpeed() / frontLeftWithEncoder.getSpeed());
		else if(Math.abs(frontLeftWithEncoder.getSpeed()) < Math.abs(frontRightWithEncoder.getSpeed()))
			rightMoveValue *= Math.abs(frontLeftWithEncoder.getSpeed() / frontRightWithEncoder.getSpeed());
		
		wheels.tankDrive(leftMoveValue, -rightMoveValue);
	}
	*/

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

}