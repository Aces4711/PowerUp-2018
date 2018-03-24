/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4711.robot.config;


public class RobotMap {
	public static final int FLTalon = 4;
	public static final int FRTalon = 1;
	public static final int BLTalon = 2;
	public static final int BRTalon = 3;
	public static final int ETalon = 5; //8
	public static final int LCTalon = 6;
	public static final int RCTalon = 7;
	public static final int WINCH = 8; //5
	
	public static final int JOYSTICK_PORT = 0;
	public static final int AXIS_TRIGGER_LT = 2;
	public static final int AXIS_TRIGGER_RT = 3;
	public static final int TRIGGER_LB = 5;
	public static final int TRIGGER_RB = 6;
	public static final int AXIS_LEFT_X = 0;
	public static final int AXIS_RIGHT_Y = 5;
	
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	
	public static final double DRIVE_WHEEL_DIAMETER = 3.94;
	public static final double ELEVATOR_WHEEL_DIAMETER = 1.0;
	
	//Inches
	public static final double ELEVATOR_HIGH_HIGHT = 66.5; 
	public static final double ELEVATOR_MID_HIGHT = 24.0;
	public static final double ELEVATOR_LOW_HIGHT = 19.0;
	public static final double ELEVATOR_GROUND_HIGHT = 0.0;
	
	// Auto selection switch
	public static final int LEFT_DIO_SWITCH = 0;
	public static final int RIGHT_DIO_SWITCH = 1;
	

	public static final int CAMERA_FRONT = 0;
	//only can use 160x120, 320x240, 640x480
	public static final int CAMERA_IMG_WIDTH = 320;
	public static final int CAMERA_IMG_HEIGHT = 240;
}