// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

/** Add your docs here. */

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Index extends SubsystemBase {
  
  public CANSparkMax indexMotor = new CANSparkMax(12, MotorType.kBrushless);


  public static boolean ballEntry = false;
  
  public static DigitalInput sensorAlpha = new DigitalInput(0);
  public static DigitalInput sensorBeta = new DigitalInput(1);
  public static DigitalInput sensorSigma = new DigitalInput(2);

  public static DigitalInput[] sensors = new DigitalInput[3];
  
  
  /** Creates a new SparkTest. */
  public Index() {
    sensors[0] = sensorAlpha;
    sensors[1] = sensorBeta;
    sensors[2] = sensorSigma;
  }
  
  public boolean getSensor(int sensorNumber) {
    return !sensors[sensorNumber].get();
  }

  public boolean getIntakeSensor() {
    return !sensorSigma.get();
  }

  public boolean getMidSensor() {
    return !sensorBeta.get();
  }

  public boolean getTopSensor() {
    return !sensorAlpha.get();
  } 
 
  public void runIndex () {
    indexMotor.set(-0.3);

  }

  public void stopIndex() {
    indexMotor.stopMotor();
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




