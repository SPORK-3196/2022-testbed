// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkTest extends SubsystemBase {
  
  public CANSparkMax sparkMaxLead = new CANSparkMax(12, MotorType.kBrushless);
  public CANSparkMax sparkMaxFollower = new CANSparkMax(14, MotorType.kBrushless);
  

  public RelativeEncoder sparkEncoder = sparkMaxLead.getEncoder();
  public SparkMaxPIDController sparkPIDController = sparkMaxLead.getPIDController();
  
  /** Creates a new SparkTest. */
  public SparkTest() {
    sparkMaxFollower.follow(sparkMaxLead, true);
  }
  
 
  public void runSparks (double power) {
    sparkMaxLead.set(power * -1);
  }

  public void stopSparks() {
    sparkMaxLead.stopMotor();
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Encoder_RPM_Entry.setDouble(sparkEncoder.getVelocity());
    Encoder_MPH_Entry.setDouble((((sparkEncoder.getVelocity() * 3) / 12) * 60) / 5280);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
