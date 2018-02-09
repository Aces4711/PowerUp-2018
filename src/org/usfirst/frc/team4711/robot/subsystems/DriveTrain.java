package org.usfirst.frc.team4711.robot.subsystems;

import org.usfirst.frc.team4711.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {
	
	DifferentialDrive drive = new DifferentialDrive(new WPI_TalonSRX(0), new WPI_TalonSRX(1));
	
	public DriveTrain() {
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
