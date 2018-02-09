package org.usfirst.frc.team4711.robot.commands;

import org.usfirst.frc.team4711.robot.OI;
import org.usfirst.frc.team4711.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Command {
	
	private DifferentialDrive drive =  Robot.driveTrain;
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void execute() {
		double velocity = OI.xboxController.getTriggerAxis(Hand.kLeft) - OI.xboxController.getTriggerAxis(Hand.kRight);
		drive.arcadeDrive(velocity, OI.xboxController.getX(Hand.kLeft));
	}
}
