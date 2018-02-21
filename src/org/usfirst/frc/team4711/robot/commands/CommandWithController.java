package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.ControllerSubsystem;
import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.KeyMap;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

//import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;

public class CommandWithController extends Command {
	
	private ControllerSubsystem _controller;
	private DriveTrain _drive;
	private ElevatorSubsystem _elevator; 
	
	public CommandWithController() {
		super("Drive With Joystick");
		
		_controller = ControllerSubsystem.getInstance();
		requires(_controller);
		
		_drive = DriveTrain.getInstance();
		requires(_drive);
		
		_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
	}
	
	protected void initialize() {
		
    }

    protected void execute() {
    	
    	_drive.arcadeDrive((_controller.getController().getRawAxis(KeyMap.ACCEL_FORWARD) > 0)? 
    											_controller.getController().getRawAxis(KeyMap.ACCEL_FORWARD) :
    											((_controller.getController().getRawAxis(KeyMap.ACCEL_BACK) > 0)? 
    													-_controller.getController().getRawAxis(KeyMap.ACCEL_BACK):
    														0.0), _controller.getController().getRawAxis(RobotMap.AXIS_LEFT_X));

    	_elevator.setMotorSpeed(_controller.getController().getRawAxis(RobotMap.AXIS_RIGHT_Y));
    	
    	//testing logging
    	System.out.println("left : " + _drive.getCurrentLeftPosition() + 
    						", right : " + _drive.getCurrentRightPosition() +
    						", elevator : " + Utils.convertPositionToInches(_elevator.getPosition(), RobotMap.ELEVATOR_WHEEL_DIAMETER));
    }
    
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
    protected void end() {
		_drive.stop();
		_elevator.setMotorSpeed(0.0);
    }
	
	@Override
    protected void interrupted() {
        end();
    }
	
}