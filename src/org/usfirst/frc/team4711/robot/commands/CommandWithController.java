package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.KeyMap;
import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.ControllerSubsystem;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

//import edu.wpi.first.wpilibj.Joystick.AxisType;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class CommandWithController extends PIDCommand {

	private ControllerSubsystem _controller;
	private DriveTrain _drive;
	private ElevatorSubsystem _elevator;

	public CommandWithController() {
		super("Drive With Joystick", 0, 0, 0);

		_controller = ControllerSubsystem.getInstance();
		requires(_controller);

		_drive = DriveTrain.getInstance();
		requires(_drive);

		_elevator = ElevatorSubsystem.getInstance();
		requires(_elevator);
	}

	@Override
	protected void initialize() {

    }

	/**
	 * Drive arcadeDrive with the controller.
	 */
    @Override
	protected void execute() {
    	double driveSpeed = _controller.getController().getRawAxis(KeyMap.ACCEL_FORWARD) +
    			_controller.getController().getRawAxis(KeyMap.ACCEL_BACK);
		double driveAngle = _controller.getController().getRawAxis(RobotMap.AXIS_LEFT_X);

    	_drive.arcadeDrive(driveSpeed, driveAngle);

    	if(Math.abs(_controller.getController().getRawAxis(RobotMap.AXIS_RIGHT_Y)) >= 0.1) {
    		if (_controller.getController().getRawAxis(RobotMap.AXIS_RIGHT_Y) < 0) {
    			setSetpoint(ElevatorSubsystem.HEIGHTS.GROUND.getHeight());
    		} else {
    			setSetpoint(ElevatorSubsystem.HEIGHTS.HIGH.getHeight());
    		}
    		getPIDController().enable();
    	} else {
    		getPIDController().disable(); 
    		_elevator.setMotorSpeed(0);
    	}
    	
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

	@Override
	protected double returnPIDInput() {
		return _elevator.getPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		_elevator.setMotorSpeed(_controller.getController().getRawAxis(RobotMap.AXIS_RIGHT_Y) * output);
	}

}