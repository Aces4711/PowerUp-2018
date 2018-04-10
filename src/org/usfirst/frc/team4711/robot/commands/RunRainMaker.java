package org.usfirst.frc.team4711.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.subsystems.ElevatorSubsystem;

public class RunRainMaker extends CommandGroup {
	public static enum Paths {
		STARTLEFT_FIRSTSWITCHLEFT,
		STARTLEFT_SECONDSWITCHLEFT,
		STARTLEFT_SECONDSWITCHRIGHT,
		STARTCENTER_FIRSTSWITCHLEFT,
		STARTCENTER_FIRSTSWITCHRIGHT,
		STARTRIGHT_FIRSTSWITCHRIGHT,
		STARTRIGHT_SECONDSWITCHRIGHT,
		STARTRIGHT_SECONDSWITCHLEFT
	}
	
    public RunRainMaker(Paths path) {
    	switch(path) {
    	case STARTLEFT_FIRSTSWITCHLEFT:
    		
    		addSequential(new DriveFor(168 - (RobotMap.ROBOT_LENGTH * .5)));
    		
    		addSequential(new WaitCommand(.5));
			addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(28 - ((RobotMap.ROBOT_LENGTH * .5) + RobotMap.BOX_HANG_OVER)));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(RobotMap.BOX_HANG_OVER + 2));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(-RobotMap.BOX_HANG_OVER + 2));
			
    		break;
    	case STARTLEFT_SECONDSWITCHLEFT:
    		
    		addSequential(new DriveFor(215 - (RobotMap.ROBOT_LENGTH * .5)));
    		
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(36));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(65 - ((RobotMap.ROBOT_LENGTH * .5) + RobotMap.BOX_HANG_OVER))); 
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.HIGH));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(110));
			
    		break;
    	case STARTLEFT_SECONDSWITCHRIGHT:
    		
    		addSequential(new DriveFor(215 - (RobotMap.ROBOT_LENGTH * .5)));
    		
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(196));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(65 - ((RobotMap.ROBOT_LENGTH * .5) + RobotMap.BOX_HANG_OVER))); 
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.HIGH));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-150));
    		break;
    	case STARTCENTER_FIRSTSWITCHLEFT:
    		
			addSequential(new DriveFor(60 - (RobotMap.ROBOT_LENGTH * .5)));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(55));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(40 - (RobotMap.ROBOT_LENGTH * .5)  + RobotMap.BOX_HANG_OVER));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(RobotMap.BOX_HANG_OVER + 2));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(-RobotMap.BOX_HANG_OVER + 2));
			
			addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
    		break;
    	case STARTCENTER_FIRSTSWITCHRIGHT:
			addSequential(new DriveFor(60 - (RobotMap.ROBOT_LENGTH * .5)));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(55));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(40 - (RobotMap.ROBOT_LENGTH * .5)  + RobotMap.BOX_HANG_OVER));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(RobotMap.BOX_HANG_OVER + 2));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(-RobotMap.BOX_HANG_OVER + 2));
			
			addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
    		break;
    	case STARTRIGHT_FIRSTSWITCHRIGHT:
    		addSequential(new DriveFor(128));
    		
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(15));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.MID));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(RobotMap.BOX_HANG_OVER + 2));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
			addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(-RobotMap.BOX_HANG_OVER + 2));
    		break;
    	case STARTRIGHT_SECONDSWITCHRIGHT:
    		addSequential(new DriveFor(215 - (RobotMap.ROBOT_LENGTH * .5)));
    		
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(36));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(65 - ((RobotMap.ROBOT_LENGTH * .5) + RobotMap.BOX_HANG_OVER))); 
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.HIGH));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-150));
    		break;
    	case STARTRIGHT_SECONDSWITCHLEFT:
    		addSequential(new DriveFor(215 - (RobotMap.ROBOT_LENGTH * .5)));
    		
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(-75));
			//addSequential(new TurnCommand(-90));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new DriveFor(196));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(75));
			//addSequential(new TurnCommand(90));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new DriveFor(65 - ((RobotMap.ROBOT_LENGTH * .5) + RobotMap.BOX_HANG_OVER))); 
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.HIGH));
			
    		addSequential(new WaitCommand(.5));
			addSequential(new ClawCommand(-1.0));
			
			
    		addSequential(new WaitCommand(.5));
			addSequential(new RunElevatorCommand(ElevatorSubsystem.HEIGHTS.GROUND));
			
    		addSequential(new WaitCommand(.5));
    		addSequential(new TurnCommand(150));

    		break;
    		
    	}
    }
}