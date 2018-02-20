package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFor extends Command {
	private DriveTrain _drive;
	
	private double _disInches;
	
    public DriveFor(double disInches) {
    	_drive = DriveTrain.getInstance();
    	requires(_drive);
    	
    	_disInches = disInches;
    	
    	setTimeout(3);
    }

    protected void initialize() {
    	System.out.println("Reset Encoders");
    	_drive.resetEncoders();
    }

    protected void execute() {
    	System.out.println("driveStraight");
    	_drive.driveStraight(_disInches > 0 ? 1.0 : -1.0);
    }

    protected boolean isFinished() {

		double wheelCircumference = Math.PI * RobotMap.DRIVE_WHEEL_DIAMETER;
		
    	double leftDis = Math.abs(_drive.getCurrentLeftPosition() * wheelCircumference);
    	double rightDis = Math.abs(_drive.getCurrentRightPosition() * wheelCircumference);
        
    	//testing logging
    	System.out.println("left : " + _drive.getCurrentLeftPosition() + ", right : " + _drive.getCurrentRightPosition());
    	return (leftDis >= Math.abs(_disInches) && rightDis >= Math.abs(_disInches)) || isTimedOut();
    }

    protected void end() {
    	_drive.stop();
    }

    protected void interrupted() {
    	end();
    }
}
