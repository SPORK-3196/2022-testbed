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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkTest extends SubsystemBase {
  
  public CANSparkMax sparkMax1 = new CANSparkMax(12, MotorType.kBrushless);
  public CANSparkMax sparkMax2 = new CANSparkMax(14, MotorType.kBrushless);
  public CANSparkMax sparkMax3 = new CANSparkMax(17, MotorType.kBrushless);
  public CANSparkMax sparkMax4 = new CANSparkMax(15, MotorType.kBrushless);

  public RelativeEncoder sparkEncoder = sparkMax1.getEncoder();
  public PIDController sparkPIDController = new PIDController(5e-5, 1e-6, 0);

  public double sparkVelocity;
  
  /** Creates a new SparkTest. */
  public SparkTest() {
    sparkMax2.setInverted(true);
  }
  
 
  public void runSparks (double power) {
    sparkMax1.set(power * -1);
    sparkMax2.set(power * -1);
    sparkMax4.set(power * -0.5);
 
  }

  public void stopSparks() {
    sparkMax1.stopMotor();
    sparkMax2.stopMotor();
    sparkMax4.stopMotor();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    sparkVelocity = sparkEncoder.getVelocity();

    Encoder_RPM_Entry.setDouble(sparkVelocity);

    Encoder_MPH_Entry.setDouble( ((sparkVelocity * SparkWheelRadiusDiameter) * 60 * Math.PI) / 63360 );
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }


}
