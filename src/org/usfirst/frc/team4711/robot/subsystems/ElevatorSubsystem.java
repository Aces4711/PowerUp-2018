package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class ElevatorSubsystem extends PIDSubsystem {
	public static enum HEIGHTS {
		GROUND(Utils.convertInchesToPosition(RobotMap.ELEVATOR_GROUND_HIGHT, RobotMap.ELEVATOR_WHEEL_DIAMETER)), 
		LOW(Utils.convertInchesToPosition(RobotMap.ELEVATOR_LOW_HIGHT, RobotMap.ELEVATOR_WHEEL_DIAMETER)), 
		MID(Utils.convertInchesToPosition(RobotMap.ELEVATOR_MID_HIGHT, RobotMap.ELEVATOR_WHEEL_DIAMETER)), 
		HIGH(Utils.convertInchesToPosition(RobotMap.ELEVATOR_HIGH_HIGHT, RobotMap.ELEVATOR_WHEEL_DIAMETER));
		
		private double _height;
		private HEIGHTS(double height) {
			_height = height;
		}
		public double getHeight() {
			return _height;
		}
	}
	
	private WPI_TalonSRX _motor;
	
	private static ElevatorSubsystem _instance;
	
	private ElevatorSubsystem () {
		super("elevatorSubsystem", 0.0, 0.0, 0.0);
		
		setAbsoluteTolerance(1.0);
		getPIDController().setContinuous(false);
		
		_motor = new WPI_TalonSRX(RobotMap.ETalon);
		_motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        _motor.setSelectedSensorPosition(0, 0, 0);
		
		//_motor.set(ControlMode.Position, 0);
		
	}
	
	public static ElevatorSubsystem getInstance(){
		if(_instance == null)
			_instance = new ElevatorSubsystem();
		
		return _instance;
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	public void setMotorSpeed(double moveValue){
		if((moveValue > 0.0 && getPosition() <= ElevatorSubsystem.HEIGHTS.GROUND.getHeight()) ||
		   (moveValue < 0.0 && getPosition() >= ElevatorSubsystem.HEIGHTS.HIGH.getHeight()))
			moveValue = 0.0;
		
		_motor.set(moveValue * MotorSpeeds.ELEVATOR_SPEED);
	}
	
	public double getPosition() {
		return _motor.getSelectedSensorPosition(0);
	}

	@Override
	protected double returnPIDInput() {
		return _motor.getSensorCollection().getQuadraturePosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		_motor.pidWrite(output);	
	}
}