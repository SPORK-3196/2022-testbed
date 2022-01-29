// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  public static XboxController XboxController;

  public static NetworkTableEntry xboxRightTriggerEntry = Shuffleboard.getTab("User Input").add("Right Trigger", 0.0).getEntry();
  public static NetworkTableEntry xboxLeftTriggerEntry = Shuffleboard.getTab("User Input").add("Left Trigger", 0.0).getEntry();

  public static NetworkTableEntry xboxRightBumperEntry = Shuffleboard.getTab("User Input").add("Right Bumper", false).getEntry();
  public static NetworkTableEntry xboxLeftBumperEntry = Shuffleboard.getTab("User Input").add("Left Bumper", false).getEntry();

  public static NetworkTableEntry xboxLeftJoystickXEntry = Shuffleboard.getTab("User Input").add("Left Joystick X", 0.0).getEntry();
  public static NetworkTableEntry xboxLeftJoystickYEntry = Shuffleboard.getTab("User Input").add("Left Joystick Y", 0.0).getEntry();
  public static NetworkTableEntry xboxRightJoystickXEntry = Shuffleboard.getTab("User Input").add("Right Joystick X", 0.0).getEntry();
  public static NetworkTableEntry xboxRightJoystickYEntry = Shuffleboard.getTab("User Input").add("Right Joystick Y", 0.0).getEntry();

  public static NetworkTableEntry xboxControllerXButtonEntry = Shuffleboard.getTab("User Input").add("X Button", false).getEntry();
  public static NetworkTableEntry xboxControllerYButtonEntry = Shuffleboard.getTab("User Input").add("Y Button", false).getEntry();
  public static NetworkTableEntry xboxControllerAButtonEntry = Shuffleboard.getTab("User Input").add("A Button", false).getEntry();
  public static NetworkTableEntry xboxControllerBButtonEntry = Shuffleboard.getTab("User Input").add("B Button", false).getEntry();

  public static double xboxRightTriggerValue;
  public static double xboxLeftTriggerValue;

  public static boolean xboxRightBumper;
  public static boolean xboxLeftBumper;

  public static double xboxLeftJoystickX;
  public static double xboxLeftJoystickY;
  public static double xboxRightJoystickX;
  public static double xboxRightJoystickY;

  public static boolean xboxControllerXButton;
  public static boolean xboxControllerYButton;
  public static boolean xboxControllerAButton;
  public static boolean xboxControllerBButton;
  


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    XboxController = new XboxController(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    xboxRightTriggerValue = XboxController.getRightTriggerAxis();
    xboxLeftTriggerValue = XboxController.getLeftTriggerAxis();
    xboxRightBumper = XboxController.getRightBumper();
    xboxLeftBumper = XboxController.getLeftBumper();

    xboxLeftJoystickX = XboxController.getLeftX();
    xboxLeftJoystickY = XboxController.getLeftY();
    xboxRightJoystickX = XboxController.getRightX();
    xboxRightJoystickY = XboxController.getRightY();

    xboxControllerXButton = XboxController.getXButton();
    xboxControllerYButton = XboxController.getYButton();
    xboxControllerAButton = XboxController.getAButton();
    xboxControllerBButton = XboxController.getBButton();


    xboxRightTriggerEntry.setDouble(xboxRightTriggerValue);
    xboxLeftTriggerEntry.setDouble(xboxLeftTriggerValue);
    xboxRightBumperEntry.setBoolean(xboxRightBumper);
    xboxLeftBumperEntry.setBoolean(xboxLeftBumper);

    xboxLeftJoystickXEntry.setDouble(xboxLeftJoystickX);
    xboxLeftJoystickYEntry.setDouble(xboxLeftJoystickY);
    xboxRightJoystickXEntry.setDouble(xboxRightJoystickX);
    xboxRightJoystickYEntry.setDouble(xboxRightJoystickY);

    xboxControllerXButtonEntry.setBoolean(xboxControllerXButton);
    xboxControllerYButtonEntry.setBoolean(xboxControllerYButton);
    xboxControllerAButtonEntry.setBoolean(xboxControllerAButton);
    xboxControllerBButtonEntry.setBoolean(xboxControllerBButton);

  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
