//Package declaration
package org.usfirst.frc.team4711.robot;

import org.usfirst.frc.team4711.robot.commands.RunRainMaker;
import org.usfirst.frc.team4711.robot.commands.TurnCommand;
import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4711.robot.subsystems.RobotEyeSubsystem;
//Import library/dependencies
import org.usfirst.frc.team4711.robot.commands.CommandWithController;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//Class declaration
public class Robot extends IterativeRobot {
	
	//Command Objects
	private Command autonomousCommand;
	private Command teleopCommand;
	
	private SendableChooser<Integer> startingLocation;

	
	public Robot() {
		//ahrs = new AHRS(SPI.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */
	}
	
	public void robotInit() {
		teleopCommand = new CommandWithController();
		
		startingLocation = new SendableChooser<>();
		
		startingLocation.addDefault("Left", 1);
		startingLocation.addObject("Center", 2);
		startingLocation.addObject("Right", 3);
		SmartDashboard.putData("Starting Location", startingLocation);
		
		System.out.println(DriverStation.getInstance().getGameSpecificMessage());
		//teleopCommand = new RunTest(RunTest.State.FREE, 0.0);
	}

	public void teleopInit() {
		if(autonomousCommand != null) 
			autonomousCommand.cancel();
		
		if(teleopCommand != null)
			teleopCommand.start();
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		if(teleopCommand != null)
			teleopCommand.cancel();
		
		
		int location = startingLocation.getSelected();
		
		/**
		int location;
		do {
			location = DriverStation.getInstance().getLocation();
		} while(location == 0);
		*/
		
		String gameSpecificMessage = null;
		do {
			gameSpecificMessage = DriverStation.getInstance().getGameSpecificMessage();
		} while(gameSpecificMessage == null || gameSpecificMessage.isEmpty());
		

		System.out.println("Starting Location: + " + location + ", gameSpecificMessage : " + gameSpecificMessage);
		
		switch(location) {
		case RobotMap.LEFT_LOCATION:
			if(gameSpecificMessage.charAt(0) == 'L')
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTLEFT_FIRSTSWITCHLEFT);
			else if(gameSpecificMessage.charAt(1) == 'L')
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTLEFT_SECONDSWITCHLEFT);
			else 
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTLEFT_SECONDSWITCHRIGHT);
			
			break;
		case RobotMap.CENTER_LOCATION:
			if(gameSpecificMessage.charAt(0) == 'L')
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTCENTER_FIRSTSWITCHLEFT);
			else
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTCENTER_FIRSTSWITCHRIGHT);
			break;
		case RobotMap.RIGHT_LOCATION:
			if(gameSpecificMessage.charAt(0) == 'R')
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTRIGHT_FIRSTSWITCHRIGHT);
			else if(gameSpecificMessage.charAt(1) == 'R')
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTRIGHT_SECONDSWITCHRIGHT);
			else 
				autonomousCommand = new RunRainMaker(RunRainMaker.Paths.STARTRIGHT_SECONDSWITCHLEFT);
			break;
		default:
			System.out.println("Error: Starting Location: + " + location + " is out side of range.");
		}
		
		//DriveTrain.getInstance().gyro.reset();

		//autonomousCommand = new TurnCommand(90);
		if(autonomousCommand != null) 
			autonomousCommand.start();
		
	}
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
}