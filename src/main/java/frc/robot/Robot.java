// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;
import static frc.robot.Constants.Shooter.*;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  public static XboxController X1_Controller;
  public static JoystickButton button1;
  public static JoystickButton button2;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    X1_Controller = new XboxController(0);
    button1 = new JoystickButton(X1_Controller, 1);
    button2 = new JoystickButton(X1_Controller, 2);
    Constants.AutoSparkFireEntry.setBoolean(Constants.AutoSparkFire);
    Constants.AutoSparkPowerEntry.setDouble(Constants.AutoSparkPower);
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

    // Retrieves values from the XboxController object and stores them in the variables initialized in Constants.java
    xboxRightTriggerValue = X1_Controller.getRightTriggerAxis();
    xboxLeftTriggerValue = X1_Controller.getLeftTriggerAxis();
    xboxRightBumper = X1_Controller.getRightBumper();
    xboxLeftBumper = X1_Controller.getLeftBumper();

    xboxLeftJoystickX = X1_Controller.getLeftX();
    xboxLeftJoystickY = X1_Controller.getLeftY();
    xboxRightJoystickX = X1_Controller.getRightX();
    xboxRightJoystickY = X1_Controller.getRightY();

    X1_XButton = X1_Controller.getXButton();
    X1_YButton = X1_Controller.getYButton();
    X1_AButton = X1_Controller.getAButton();
    X1_BButton = X1_Controller.getBButton();

    // Stores values stored in the controller variables and sends the information to the NetworkTable Entries
    xboxRightTriggerEntry.setDouble(xboxRightTriggerValue);
    xboxLeftTriggerEntry.setDouble(xboxLeftTriggerValue);
    xboxRightBumperEntry.setBoolean(xboxRightBumper);
    xboxLeftBumperEntry.setBoolean(xboxLeftBumper);

    xboxLeftJoystickXEntry.setDouble(xboxLeftJoystickX);
    xboxLeftJoystickYEntry.setDouble(xboxLeftJoystickY);
    xboxRightJoystickXEntry.setDouble(xboxRightJoystickX);
    xboxRightJoystickYEntry.setDouble(xboxRightJoystickY);

    xboxControllerXButtonEntry.setBoolean(X1_XButton);
    xboxControllerYButtonEntry.setBoolean(X1_YButton);
    xboxControllerAButtonEntry.setBoolean(X1_AButton);
    xboxControllerBButtonEntry.setBoolean(X1_BButton);

    AutoSparkFire = AutoSparkFireEntry.getBoolean(false);
    AutoSparkPower = AutoSparkPowerEntry.getDouble(0.2);

    sparkTargetRPM = sparkTargetRPMEntry.getDouble(3000);
    sparkTargetRPMEntry.setDouble(sparkTargetRPM);

    limelightCalculatedRPM = (1459) * (Math.pow(Math.E, (0.00116 * limelightCalculatedDistance)));
    
    limelightCalculatedDistance = distanceEntry.getDouble(3000);
    distanceEntry.setDouble(limelightCalculatedDistance);

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
