package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.Utils;
import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFor extends Command {
	private DriveTrain _drive;
	
	private double _disPosition;
	private double _rightInitialPosition;
	private double _leftInitialPosition;
	
    public DriveFor(double disInches) {
    	_drive = DriveTrain.getInstance();
    	requires(_drive);
    	
    	_disPosition = Utils.convertInchesToPosition(disInches, RobotMap.DRIVE_WHEEL_DIAMETER);
    	
    	setTimeout(10);
    }

    protected void initialize() {
    	_leftInitialPosition = _drive.getCurrentLeftPosition();
    	_rightInitialPosition = _drive.getCurrentRightPosition();
    	execute();
    }

    protected void execute() {
    	_drive.driveStraight(_disPosition > 0 ? 1.0 : -1.0);
    }

    protected boolean isFinished() {
        

    	return (Math.abs(_drive.getCurrentLeftPosition() - _leftInitialPosition) >= Math.abs(_disPosition) && 
    			Math.abs(_drive.getCurrentRightPosition() - _rightInitialPosition) >= Math.abs(_disPosition)) ||
    			isTimedOut();
    }

    protected void end() {
    	_drive.stop();
    }

    protected void interrupted() {
    	end();
    }
}
