// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Intake;
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
  Intake INTAKE_SPARK;


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
    SPARK_MAXES.sparkPIDController.setP(0.00005);
    SPARK_MAXES.sparkPIDController.setI(0.0002);
    SPARK_MAXES.sparkPIDController.setD(2.0); 
    SPARK_MAXES.sparkPIDController.setSetpoint(sparkTargetRPMEntry.getDouble(3000));
    AutoSparkFire = true;
  }
    

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SPARK_MAXES.sparkPIDController.setP(0.00005);
    SPARK_MAXES.sparkPIDController.setI(0.0002);
    SPARK_MAXES.sparkPIDController.setD(5.0); 
    System.out.println(SPARK_MAXES.sparkPIDController.calculate(-1 * SPARK_MAXES.sparkVelocity));
    SPARK_MAXES.runSparks(SPARK_MAXES.sparkPIDController.calculate(-1 * SPARK_MAXES.sparkVelocity));

    INTAKE_SPARK.runIntake(INTAKE_SPARK.)
    
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
