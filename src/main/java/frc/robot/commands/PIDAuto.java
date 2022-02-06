// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SparkTest;
import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class PIDAuto extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  SparkTest SPARK_MAXES;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  public PIDAuto(SparkTest sparkMaxSubsystem) {
    SPARK_MAXES = sparkMaxSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(SPARK_MAXES);
  }

  private void addRequirements(SparkTest sPARK_MAXES2) {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SPARK_MAXES.sparkPIDController.setP(5e-5);
    SPARK_MAXES.sparkPIDController.setI(1e-6);
    SPARK_MAXES.sparkPIDController.setD(0); 
    SPARK_MAXES.sparkPIDController.setIZone(0);
    SPARK_MAXES.sparkPIDController.setFF(0.000156);
    SPARK_MAXES.sparkPIDController.setOutputRange(1000, 5700);
    AutoSparkFire = true;
  }
    

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SPARK_MAXES.sparkPIDController.setReference(3000, ControlType.kVelocity);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
