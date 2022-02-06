// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.SparkTest;
import static frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

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

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SPARK_MAXES.sparkPIDController.setP(sparkPEntry.getDouble(5e-5));
    SPARK_MAXES.sparkPIDController.setI(sparkIEntry.getDouble(1e-6));
    SPARK_MAXES.sparkPIDController.setD(sparkDEntry.getDouble(0.0)); 
    SPARK_MAXES.sparkPIDController.setSetpoint(3000);
    AutoSparkFire = true;
  }
    

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SPARK_MAXES.sparkPIDController.setP(sparkPEntry.getDouble(5e-5));
    SPARK_MAXES.sparkPIDController.setI(sparkIEntry.getDouble(1e-6));
    SPARK_MAXES.sparkPIDController.setD(sparkDEntry.getDouble(0.0)); 
    System.out.println(SPARK_MAXES.sparkPIDController.calculate(-1 * SPARK_MAXES.sparkVelocity));
    SPARK_MAXES.runSparks(SPARK_MAXES.sparkPIDController.calculate(-1 * SPARK_MAXES.sparkVelocity));
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
