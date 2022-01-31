// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SparkTest;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class JoystickSparkControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  SparkTest SPARK_MAXES;
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickSparkControl(SparkTest sparkMaxSubsystem) {
    SPARK_MAXES = sparkMaxSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SPARK_MAXES);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (Constants.xboxLeftJoystickY < 0) {
      SPARK_MAXES.runSpark1(Constants.xboxLeftJoystickY * -1);
    }
    else if (Constants.xboxLeftJoystickY > 0) {
      SPARK_MAXES.runSpark1(Constants.xboxLeftJoystickY * -1);
    }
    else {
      SPARK_MAXES.stopSparks();
    }
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
