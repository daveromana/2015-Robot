package com.team1389.auton;

import com.kauailabs.nav6.frc.IMU;
import com.team1389.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends PIDSubsystem{
	final double leftModifyer = -1;
	final double rightModifyer = 1;
	
	private double speed;
	private IMU imu;
	public DriveStraight(IMU imu, double speed){
		super(.05, .002, 0);
		this.speed = speed;
		this.imu=imu;
		setInputRange(-180, 180);
		setOutputRange(-.1, .1);
		getPIDController().setContinuous();
	}

	@Override
	protected double returnPIDInput(){
		float pidOutput = imu.getYaw();
		return pidOutput;
	}

	@Override
	protected void usePIDOutput(double output) {
//		Robot.left1.set(leftModifyer * speed + output);
//		Robot.left2.set(leftModifyer * speed + output);
//		Robot.right1.set(rightModifyer * speed + output); 
//		Robot.right2.set(rightModifyer * speed + output);
		Robot.driveControl.drive(output, speed);
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	@Override
	public void disable() {
		super.disable();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
}
