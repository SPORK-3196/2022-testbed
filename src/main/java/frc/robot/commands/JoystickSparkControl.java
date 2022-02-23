// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.SparkTest;
import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class JoystickSparkControl extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  Shooter shooter;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickSparkControl(Shooter Subsystem) {
    shooter = Subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    shooter.runShooter(xboxLeftJoystickY * -1);
    

    /*
    if (Robot.xboxRightJoystickY < 0) {
      SPARK_MAXES.runSpark2(Robot.xboxRightJoystickY * -1);
    }
    else if (Robot.xboxRightJoystickY > 0) {
      SPARK_MAXES.runSpark2(Robot.xboxRightJoystickY * -1);
    }
    else {
      SPARK_MAXES.stopSpark2();
    }
    */
    
    
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
