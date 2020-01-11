// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5514.DeepSpaceCmdArch.subsystems;

import org.usfirst.frc5514.DeepSpaceCmdArch.Robot;
import org.usfirst.frc5514.DeepSpaceCmdArch.RobotMap;
import org.usfirst.frc5514.DeepSpaceCmdArch.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	private final int kFrontLeftCIM = 0;
	private final int kFrontLeft775 = 1;
	private final int kFrontRightCIM = 2;
	private final int kFrontRight775 = 3;
	private final int kBackLeftCIM = 4;
	private final int kBackLeft775 = 5;
	private final int kBackRightCIM = 6;
	private final int kBackRight775 = 7;
	
	WPI_TalonSRX frontLeftMotor;
	WPI_TalonSRX rearLeftMotor;
	WPI_TalonSRX frontRightMotor;
	WPI_TalonSRX rearRightMotor;
	
	WPI_TalonSRX frontLeft775;
	WPI_TalonSRX frontRight775;
	WPI_TalonSRX backLeft775;
	WPI_TalonSRX backRight775;
	
	private double speedLimit;
	private double rotateLimit;
	
	public MecanumDrive myDrive;
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public DriveTrain (double speedLimit, double rotateLimit) {
		
		frontLeftMotor = new WPI_TalonSRX(kFrontLeftCIM);
		rearLeftMotor = new WPI_TalonSRX(kBackLeftCIM);
		frontRightMotor = new WPI_TalonSRX(kFrontRightCIM);
		rearRightMotor = new WPI_TalonSRX(kBackRightCIM);
		
		frontLeft775 = new WPI_TalonSRX(kFrontLeft775);
		frontRight775 = new WPI_TalonSRX(kFrontRight775);
		backLeft775 = new WPI_TalonSRX(kBackLeft775);
		backRight775 = new WPI_TalonSRX(kBackRight775);
		
		this.speedLimit = speedLimit;
		this.rotateLimit = rotateLimit;
		
		myDrive = new MecanumDrive(frontLeft775, backLeft775, frontRight775, backRight775);
		
		frontLeftMotor.follow(frontLeft775);
		frontRightMotor.follow(frontRight775);
		rearLeftMotor.follow(backLeft775);
		rearRightMotor.follow(backRight775);
		
		System.out.println("Constructors are working");
	
	}
	
	public DriveTrain() {
		
		frontLeftMotor = new WPI_TalonSRX(kFrontLeftCIM);
		rearLeftMotor = new WPI_TalonSRX(kBackLeftCIM);
		frontRightMotor = new WPI_TalonSRX(kFrontRightCIM);
		rearRightMotor = new WPI_TalonSRX(kBackRightCIM);
		
		frontLeft775 = new WPI_TalonSRX(kFrontLeft775);
		frontRight775 = new WPI_TalonSRX(kFrontRight775);
		backLeft775 = new WPI_TalonSRX(kBackLeft775);
		backRight775 = new WPI_TalonSRX(kBackRight775);
		
		speedLimit = .4;
		rotateLimit = .4;
		
		myDrive = new MecanumDrive(frontLeft775, backLeft775, frontRight775, backRight775);
		
		frontLeftMotor.follow(frontLeft775);
		frontRightMotor.follow(frontRight775);
		rearLeftMotor.follow(backLeft775);
		rearRightMotor.follow(backRight775);
		
		System.out.println("Constructors are working");
		
	}
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new JoystickInput());
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
			
			myDrive.driveCartesian((Robot.oi.getX() * speedLimit), (Robot.oi.getY() * speedLimit), (Robot.oi.getRotate() * rotateLimit));
    	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
