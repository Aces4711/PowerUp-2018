package org.usfirst.frc.team4711.robot.subsystems;

//import org.usfirst.frc.team4711.robot.commands.CommandWithController;
//import org.usfirst.frc.team4711.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends Subsystem {
	private WPI_TalonSRX _rightWithEncoder, _leftWithEncoder;
	private DifferentialDrive _wheels;
	
	public ADXRS450_Gyro gyro;
	
	private static DriveTrain _instance;

	private DriveTrain() {
		super("driveSubsystem");
		
		gyro = new ADXRS450_Gyro();
		
		WPI_TalonSRX left = new WPI_TalonSRX(RobotMap.FLTalon);
		WPI_TalonSRX right = new WPI_TalonSRX(RobotMap.FRTalon);
		
		_leftWithEncoder = new WPI_TalonSRX(RobotMap.BLTalon);
		_leftWithEncoder.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
;
		_rightWithEncoder = new WPI_TalonSRX(RobotMap.BRTalon);
		_rightWithEncoder.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	
	    SpeedControllerGroup leftGroup = new SpeedControllerGroup(left, _leftWithEncoder);
		SpeedControllerGroup rightGroup = new SpeedControllerGroup(right, _rightWithEncoder);

		_wheels = new DifferentialDrive(leftGroup, rightGroup);
		_wheels.setSafetyEnabled(false);
		
	}
	
	public static DriveTrain getInstance(){
		if(_instance == null)
			_instance = new DriveTrain();
		
		return _instance;
	}
	
	public void arcadeDrive(double moveValue, double rotateValue){
		_wheels.arcadeDrive(moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL, rotateValue * MotorSpeeds.DRIVE_SPEED_TURN);
	}	
	
	public void stop(){
		_wheels.stopMotor();
	}
	
	public void resetEncoders() {
		_leftWithEncoder.setSelectedSensorPosition(0, 0, 0);
		_rightWithEncoder.setSelectedSensorPosition(0, 0, 0);
	}
	
	public int getCurrentRightPosition() {
		return _rightWithEncoder.getSelectedSensorPosition(0);
	}
	
	public int getCurrentLeftPosition() {
		return _leftWithEncoder.getSelectedSensorPosition(0);
	}
	
	public void driveStraight(double moveValue){
		double leftMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL;
		double rightMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_ACCEL;
		
		double rightSpeed = Math.abs(_rightWithEncoder.getSelectedSensorVelocity(0));
		double leftSpeed = Math.abs(_leftWithEncoder.getSelectedSensorVelocity(0));
		
		if(rightSpeed > leftSpeed)
			rightMoveValue *= leftMoveValue / rightMoveValue;
		else if(leftSpeed > rightSpeed)
			leftMoveValue *= rightMoveValue / leftMoveValue;
		
		_wheels.tankDrive(rightMoveValue, leftMoveValue);
		
	}
	
	public void turnOnAxis(double moveValue) {
		double leftMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_TURN;
		double rightMoveValue = moveValue * MotorSpeeds.DRIVE_SPEED_TURN;
		
		double rightSpeed = Math.abs(_rightWithEncoder.getSelectedSensorVelocity(0));
		double leftSpeed = Math.abs(_leftWithEncoder.getSelectedSensorVelocity(0));
		
		if(rightSpeed > leftSpeed)
			rightMoveValue *= leftMoveValue / rightMoveValue;
		else if(leftSpeed > rightSpeed)
			leftMoveValue *= rightMoveValue / leftMoveValue;
		
		_wheels.tankDrive(leftMoveValue, -rightMoveValue);
	}

	@Override
	protected void initDefaultCommand() {
	}
}