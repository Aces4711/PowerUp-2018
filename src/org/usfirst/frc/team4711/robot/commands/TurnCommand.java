package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnCommand extends Command {

	private DriveTrain _drive;
	private double _dir;
	
	private double _disPosition;
	private int _rightInitialPosition;
	private int _leftInitialPosition;
	
    public TurnCommand(double angle) {
		super("TurnCommand");

		_dir = angle > 0 ? 1.0 : -1.0;
		 
    	double length = RobotMap.ROBOT_WHEELS_SPACING * Math.PI * (Math.abs(angle) / 360);
		_disPosition = Utils.convertInchesToPosition(length, RobotMap.DRIVE_WHEEL_DIAMETER);

		_drive = DriveTrain.getInstance();
		requires(_drive);
		
		setTimeout(5);
    }

    @Override
    protected void initialize() {
    	_leftInitialPosition = _drive.getCurrentLeftPosition();
    	_rightInitialPosition = _drive.getCurrentRightPosition();
    	execute();
    }

    @Override
    protected void execute() {
    	_drive.turnOnAxis(_dir);
    	double currentDis = _dir > 0 ? _drive.getCurrentLeftPosition() - _leftInitialPosition :
			   						   _drive.getCurrentRightPosition() - _rightInitialPosition;
    	double angle = Utils.convertPositionToInches(currentDis, RobotMap.DRIVE_WHEEL_DIAMETER);
    	angle /= RobotMap.ROBOT_WHEELS_SPACING * Math.PI;
    	angle *= 360;
    	System.out.println("Angle : " + angle);
    	
    }

    @Override
    protected boolean isFinished() {
    	double currentDis = _dir > 0 ? _drive.getCurrentLeftPosition() - _leftInitialPosition :
    								   _drive.getCurrentRightPosition() - _rightInitialPosition;
        return Math.abs(currentDis) >= _disPosition || isTimedOut();
    }

    @Override
    protected void end() {
    	_drive.stop();
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
