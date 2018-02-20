package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.commands.CommandWithController;
import org.usfirst.frc.team4711.robot.config.MotorSpeeds;
import org.usfirst.frc.team4711.robot.config.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorSubsystem extends Subsystem {
	
	private WPI_TalonSRX _motor;
	
	private static ElevatorSubsystem _instance;
	
	private ElevatorSubsystem () {
		super("elevatorSubsystem");
		
		_motor = new WPI_TalonSRX(RobotMap.ETalon);
		_motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		
		//_motor.set(ControlMode.Position, 0);
		//_motor.setSelectedSensorPosition(0, 0, 0);
		
	}
	
	public static ElevatorSubsystem getInstance(){
		if(_instance == null)
			_instance = new ElevatorSubsystem();
		
		return _instance;
	}

	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new CommandWithController());
	}
	
	public void setMotorSpeed(double moveValue){
		_motor.set(moveValue * MotorSpeeds.ELEVATOR_SPEED);
	}
	
	public int getPosition() {
		return _motor.getSelectedSensorPosition(0);
	}
}