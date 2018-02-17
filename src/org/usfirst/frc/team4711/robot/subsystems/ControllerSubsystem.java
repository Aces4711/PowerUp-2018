package org.usfirst.frc.team4711.robot.subsystems;

/*
import org.usfirst.frc.team4711.robot.commands.RunLauncher;
import org.usfirst.frc.team4711.robot.commands.RunLauncherBaseOnDistance;
import org.usfirst.frc.team4711.robot.commands.AimForTarget;
import org.usfirst.frc.team4711.robot.commands.DriveFor;
import org.usfirst.frc.team4711.robot.commands.BackUpTo;
import org.usfirst.frc.team4711.robot.commands.RunClimber;
import org.usfirst.frc.team4711.robot.commands.RunIntake;
*/
import org.usfirst.frc.team4711.robot.config.KeyMap;

import org.usfirst.frc.team4711.robot.config.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ControllerSubsystem extends Subsystem {
	private Joystick joystick;
	/*
	private JoystickButton intakeButton;
	private JoystickButton intakeUnjamButton;
	private JoystickButton winchUpButton;
	private JoystickButton winchDownButton;
	private JoystickButton continuousLaunchButton;
	private JoystickButton distanceLaunchButton;
	private JoystickButton slowReverseButton;
	*/

	private static ControllerSubsystem instance;
	
	private ControllerSubsystem(){
		joystick = new Joystick(RobotMap.JOYSTICK_PORT);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static ControllerSubsystem getInstance(){
		if(instance == null)
			instance = new ControllerSubsystem();
		
		return instance;
	}
	
	public Joystick getController(){
		return joystick;
	}

}
