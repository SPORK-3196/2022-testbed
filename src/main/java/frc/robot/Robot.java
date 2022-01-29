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

  public static NetworkTableEntry rightTriggerEntry = Shuffleboard.getTab("User Input").add("Right Trigger", 0.0).getEntry();
  public static NetworkTableEntry leftTriggerEntry = Shuffleboard.getTab("User Input").add("Left Trigger", 0.0).getEntry();

  public static NetworkTableEntry rightBumperEntry = Shuffleboard.getTab("User Input").add("Right Bumper", false).getEntry();
  public static NetworkTableEntry leftBumperEntry = Shuffleboard.getTab("User Input").add("Left Bumper", false).getEntry();

  public static NetworkTableEntry leftJoystickXEntry = Shuffleboard.getTab("User Input").add("Left Joystick X", 0.0).getEntry();
  public static NetworkTableEntry leftJoystickYEntry = Shuffleboard.getTab("User Input").add("Left Joystick Y", 0.0).getEntry();
  public static NetworkTableEntry rightJoystickXEntry = Shuffleboard.getTab("User Input").add("Right Joystick X", 0.0).getEntry();
  public static NetworkTableEntry rightJoystickYEntry = Shuffleboard.getTab("User Input").add("Right Joystick Y", 0.0).getEntry();

  public static NetworkTableEntry controllerXButtonEntry = Shuffleboard.getTab("User Input").add("X Button", false).getEntry();
  public static NetworkTableEntry controllerYButtonEntry = Shuffleboard.getTab("User Input").add("Y Button", false).getEntry();
  public static NetworkTableEntry controllerAButtonEntry = Shuffleboard.getTab("User Input").add("A Button", false).getEntry();
  public static NetworkTableEntry controllerBButtonEntry = Shuffleboard.getTab("User Input").add("B Button", false).getEntry();

  public static double rightTriggerValue;
  public static double leftTriggerValue;

  public static boolean rightBumper;
  public static boolean leftBumper;

  public static double leftJoystickX;
  public static double leftJoystickY;
  public static double rightJoystickX;
  public static double rightJoystickY;

  public static boolean controllerXButton;
  public static boolean controllerYButton;
  public static boolean controllerAButton;
  public static boolean controllerBButton;
  


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
    rightTriggerValue = XboxController.getRightTriggerAxis();
    leftTriggerValue = XboxController.getLeftTriggerAxis();
    rightBumper = XboxController.getRightBumper();
    leftBumper = XboxController.getLeftBumper();

    leftJoystickX = XboxController.getLeftX();
    leftJoystickY = XboxController.getLeftY();
    rightJoystickX = XboxController.getRightX();
    rightJoystickY = XboxController.getRightY();

    controllerXButton = XboxController.getXButton();
    controllerYButton = XboxController.getYButton();
    controllerAButton = XboxController.getAButton();
    controllerBButton = XboxController.getBButton();


    rightTriggerEntry.setDouble(rightTriggerValue);
    leftTriggerEntry.setDouble(leftTriggerValue);
    rightBumperEntry.setBoolean(rightBumper);
    leftBumperEntry.setBoolean(leftBumper);

    leftJoystickXEntry.setDouble(leftJoystickX);
    leftJoystickYEntry.setDouble(leftJoystickY);
    rightJoystickXEntry.setDouble(rightJoystickX);
    rightJoystickYEntry.setDouble(rightJoystickY);

    controllerXButtonEntry.setBoolean(controllerXButton);
    controllerYButtonEntry.setBoolean(controllerYButton);
    controllerAButtonEntry.setBoolean(controllerAButton);
    controllerBButtonEntry.setBoolean(controllerBButton);

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
