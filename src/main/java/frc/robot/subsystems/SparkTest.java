// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkTest extends SubsystemBase {
  
  public CANSparkMax sparkMax_1 = new CANSparkMax(12, MotorType.kBrushless);
  public CANSparkMax sparkMax_2 = new CANSparkMax(14, MotorType.kBrushless);
  
  /** Creates a new ExampleSubsystem. */
  public SparkTest() {
    sparkMax_2.setInverted(true);
  }
  
  public void runSpark1 (double power) {
    sparkMax_1.set(power);
  }

  public void runSparks (double power) {
    sparkMax_1.set(power);
    sparkMax_2.set(power);
  }

  public void runSpark2 (double power) {
    sparkMax_2.set(power);
  }

  public void stopSparks() {
    sparkMax_1.set(0);
    sparkMax_2.set(0);
  }

  public void stopSpark1() {
    sparkMax_1.set(0);
  }
  
  public void stopSpark2() {
    sparkMax_2.set(0);
  }
    sparkMax_1.stopMotor();
    sparkMax_2.stopMotor();
  }
  
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
