package org.usfirst.frc.team4711.robot.subsystems;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import org.usfirst.frc.team4711.robot.config.RobotMap;
import org.usfirst.frc.team4711.robot.vision.GripPipeline;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;

public class RobotEyeSubsystem extends Subsystem {
	public static enum Target {
		GEAR, BASKET;
	}

	private Thread visionThreadFront;
	
	private CvSink cvSinkFront;
	private CvSource cvSourceFront;
	
	private GripPipeline gripPipeline;
	
	private Object lock;
	private double positionX;
	
	private static RobotEyeSubsystem instance;
	
	private RobotEyeSubsystem(){
		super("robotEyeSubsystem");

		UsbCamera cameraFront = CameraServer.getInstance().startAutomaticCapture("cam0", RobotMap.CAMERA_FRONT);
		cameraFront.setResolution(RobotMap.CAMERA_IMG_WIDTH, RobotMap.CAMERA_IMG_HEIGHT);
		cameraFront.setBrightness(25);
		
		
		cvSinkFront = CameraServer.getInstance().getVideo(cameraFront);
		cvSourceFront = CameraServer.getInstance().putVideo("RobotEyeFront", RobotMap.CAMERA_IMG_WIDTH, RobotMap.CAMERA_IMG_HEIGHT);
		
		gripPipeline = new GripPipeline();
		
		lock = new Object();
		positionX = 1.0;
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	public static RobotEyeSubsystem getInstance() {
		if(instance == null)
			instance = new RobotEyeSubsystem();
		
		return instance;
	}
	
	public void startVisionFront(){
		synchronized (lock) {
        	positionX = 1.0;
        }
		
		visionThreadFront = new Thread(() -> {
			Mat source = new Mat();
			
			while(!Thread.interrupted()){
				if(cvSinkFront.grabFrame(source)==0){
					cvSourceFront.notifyError(cvSinkFront.getError());
					continue;
				}
				 /**
				gripPipeline.process(source);
				if (!gripPipeline.filterContoursOutput().isEmpty()){
					Rect r = new Rect(RobotMap.CAMERA_IMG_WIDTH, RobotMap.CAMERA_IMG_HEIGHT, 0, 0);
					for(MatOfPoint matOfPoint : gripPipeline.filterContoursOutput()) {
						Rect temp = Imgproc.boundingRect(matOfPoint);
						r.x = Math.min(r.x, temp.x);
						r.y = Math.min(r.y, temp.y);
						r.width = Math.max(r.x + r.width, temp.x + temp.width) - r.x;
						r.height = Math.max(r.y + r.height, temp.y + temp.height) - r.y;
					}
					
					Imgproc.rectangle(
							source, 
							new Point(r.x,r.y), 
							new Point(r.x + r.width, r.y + r.height), 
							new Scalar(255, 255, 255), 
							2);
					
		            double rectCenterX = r.x + (r.width / 2);
		            double camImgCenterX = RobotMap.CAMERA_IMG_WIDTH / 2;
		            
		            synchronized (lock) {
		            	positionX = -((camImgCenterX - rectCenterX) / camImgCenterX);
		            }
				}
				
				Imgproc.line(
						source, 
						new Point(RobotMap.CAMERA_IMG_WIDTH / 2, 0), 
						new Point(RobotMap.CAMERA_IMG_WIDTH / 2, RobotMap.CAMERA_IMG_HEIGHT), 
						new Scalar(255,255,255));
				
				Imgproc.putText(
						source, 
						"PositionX : " + getTargetCenterX(), 
						new Point(10, 10), 
						Core.FONT_HERSHEY_COMPLEX, 
						.5, 
						new Scalar(255,255,255),
						1);
				*/
				cvSourceFront.putFrame(source);
			}
		});
		
		visionThreadFront.start();
	}
	
	public void endVisionFront() {
		if(visionThreadFront.getState() == Thread.State.RUNNABLE)
			visionThreadFront.interrupt();
	}
	
	//-1 <= value => 1, 0 been centered
	public double getTargetCenterX(){
		double targetCenterX;
		synchronized(lock){
			targetCenterX = positionX;
		}
		
		return targetCenterX;
		
	}

}
