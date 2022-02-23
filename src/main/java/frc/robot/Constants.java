// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 
public final class Constants {

    // Retrieve shuffleboard tabs
    public static ShuffleboardTab XboxInput1 =  Shuffleboard.getTab("Xbox Controller #1");
    public static ShuffleboardTab XboxInput2 =  Shuffleboard.getTab("Xbox Controller #2");
    public static ShuffleboardTab AutoControls =  Shuffleboard.getTab("Autonomous Controls");
    public static ShuffleboardTab shooterTab =  Shuffleboard.getTab("Shooter");

    //Create variables and NetworkTableEntries to store input from xbox controller (0)
    
    public static double xboxRightTriggerValue;
    public static double xboxLeftTriggerValue;

    public static NetworkTableEntry xboxRightTriggerEntry = XboxInput1.add("Right Trigger", 0.0).getEntry();
    public static NetworkTableEntry xboxLeftTriggerEntry = XboxInput1.add("Left Trigger", 0.0).getEntry();

    public static boolean xboxRightBumper;
    public static boolean xboxLeftBumper;

    public static NetworkTableEntry xboxRightBumperEntry = XboxInput1.add("Right Bumper", false).getEntry();
    public static NetworkTableEntry xboxLeftBumperEntry = XboxInput1.add("Left Bumper", false).getEntry();

    public static double xboxLeftJoystickX;
    public static double xboxLeftJoystickY;
    public static double xboxRightJoystickX;
    public static double xboxRightJoystickY;

    public static NetworkTableEntry xboxLeftJoystickXEntry = XboxInput1.add("Left Joystick X", 0.0).getEntry();
    public static NetworkTableEntry xboxLeftJoystickYEntry = XboxInput1.add("Left Joystick Y", 0.0).getEntry();
    public static NetworkTableEntry xboxRightJoystickXEntry = XboxInput1.add("Right Joystick X", 0.0).getEntry();
    public static NetworkTableEntry xboxRightJoystickYEntry = XboxInput1.add("Right Joystick Y", 0.0).getEntry();

    public static boolean xboxControllerXButton;
    public static boolean xboxControllerYButton;
    public static boolean xboxControllerAButton;
    public static boolean xboxControllerBButton;

    public static NetworkTableEntry xboxControllerXButtonEntry = XboxInput1.add("X Button", false).getEntry();
    public static NetworkTableEntry xboxControllerYButtonEntry = XboxInput1.add("Y Button", false).getEntry();
    public static NetworkTableEntry xboxControllerAButtonEntry = XboxInput1.add("A Button", false).getEntry();
    public static NetworkTableEntry xboxControllerBButtonEntry = XboxInput1.add("B Button", false).getEntry();


    // Create variables for autonomous control
    public static double AutoSparkPower = 0.2;
    public static boolean AutoSparkFire = true;

    public static NetworkTableEntry AutoSparkFireEntry = AutoControls.add("Run Spark MAXes During Auto?", false).getEntry();
    public static NetworkTableEntry AutoSparkPowerEntry = AutoControls.add("Set Spark Power", 0.0).getEntry();

    public static double SparkWheelRadiusInches = 3;
    public static double SparkWheelRadiusDiameter = 6;

    public static NetworkTableEntry Encoder_RPM_Entry = shooterTab.add("SPARK RPM", 0.0).getEntry();
    public static NetworkTableEntry Encoder_MPH_Entry = shooterTab.add("SPARK MPH", 0.0).getEntry();

    public static double sparkP = 0.0;
    public static double sparkI = 0.0;
    public static double sparkD = 0.0;

    public static NetworkTableEntry sparkPEntry = shooterTab.add("SPARK P", 0.0).getEntry();
    public static NetworkTableEntry sparkIEntry = shooterTab.add("SPARK I", 0.0).getEntry();
    public static NetworkTableEntry sparkDEntry = shooterTab.add("SPARK D", 0.0).getEntry();

    public static double sparkTargetRPM = 3000;
    public static NetworkTableEntry sparkTargetRPMEntry = shooterTab.add("RPM GOAL", 3000.0).getEntry();

    public static NetworkTableEntry sparkPower = shooterTab.add("SPARK Power", 0.0).getEntry();

    public static double limelightCalculatedRPM;

    public static double limelightCalculatedDistance;


}
