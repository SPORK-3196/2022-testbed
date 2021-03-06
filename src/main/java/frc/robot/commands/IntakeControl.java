// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Index;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.*;


/** An example command that uses an example subsystem. */
public class IntakeControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  Intake intake;
  Index index;
  boolean runIndex = false;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeControl(Intake intake, Index index) {
    this.intake = intake;
    this.index = index;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
    addRequirements(index);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (!index.getIntakeSensor() && !index.getMidSensor() && !index.getTopSensor()) {
      runIndex = false;
    }
    
    if (index.getIntakeSensor() || index.ballEntry) {
      runIndex = true;
      index.ballEntry = true;
    }

    if (index.getMidSensor()) {
      runIndex = false;
      index.ballEntry = false;
    }

    if (index.getMidSensor() && index.getIntakeSensor()) {
      runIndex = true;
      index.ballEntry = true;
    }

    if (index.getTopSensor()) {
      runIndex = false;
      index.ballEntry = false;
    }

    if (X1_AButton) {
      if (readyToFire) {
        runIndex = true;
      }
      if (!readyToFire) {
        runIndex = false;
      }
    }

    
    

    if (runIndex) {
      index.runIndex();
    }
    else if (!runIndex) {
      index.stopIndex();
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    index.stopIndex();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
