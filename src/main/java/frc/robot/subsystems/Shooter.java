// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;


public class Shooter extends SubsystemBase { // Made By Caputo
  public CANSparkMax leftShooter = new CANSparkMax(17, MotorType.kBrushless);
  public CANSparkMax rightShooter = new CANSparkMax(15, MotorType.kBrushless);

  public RelativeEncoder shooterEncoder = leftShooter.getEncoder();

  public PIDController shooterPIDController = new PIDController(0.00005, 0.0002, 5.0);

  public double sparkVelocityRPM;
  
  /** Creates a new SparkTest. */
  public Shooter() {
    rightShooter.setInverted(true);
  }
  
 
  public void runShooter(double power) {
    leftShooter.set(power);
    rightShooter.set(power);
  }

  public void stopShooter() {
    leftShooter.stopMotor();
    rightShooter.stopMotor();
  } 

  public void setSetpoint(double RPM) {
    shooterPIDController.setSetpoint(RPM);
  }

  public double calculate(double currentRPM) {
    return shooterPIDController.calculate(currentRPM);
  }

  public double getVelocity() {
    return sparkVelocityRPM;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    sparkVelocityRPM = shooterEncoder.getVelocity();

    Encoder_RPM_Entry.setDouble(sparkVelocityRPM);

    Encoder_MPH_Entry.setDouble( ((sparkVelocityRPM * SparkWheelRadiusDiameter) * 60 * Math.PI) / 63360 );
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}