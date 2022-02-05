// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.*;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkTest extends PIDSubsystem {
  
  public CANSparkMax sparkMax_1 = new CANSparkMax(12, MotorType.kBrushless);
  public CANSparkMax sparkMax_2 = new CANSparkMax(14, MotorType.kBrushless);

  public RelativeEncoder sparkEncoder = sparkMax_1.getEncoder();
  
  /** Creates a new ExampleSubsystem. */
  public SparkTest() {
    super(
      new PIDController(sparkP.getDouble(0.0), sparkI.getDouble(0.0), sparkD.getDouble(0.0)));
    sparkMax_2.setInverted(true);
  }
  
  public void runSpark1 (double power) {
    sparkMax_1.set(power * -1);
  }

  public void runSparks (double power) {
    sparkMax_1.set(power * -1);
    sparkMax_2.set(power * -1);
  }

  public void runSpark2 (double power) {
    sparkMax_2.set(power * -1);
  }

  public void stopSparks() {
    sparkMax_1.stopMotor();
    sparkMax_2.stopMotor();
  }

  public void stopSpark1() {
    sparkMax_1.set(0);
  }
  
  public void stopSpark2() {
    sparkMax_2.set(0);
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


  @Override
  protected void useOutput(double output, double setpoint) {
    // TODO Auto-generated method stub
    
  }

  @Override
  protected double getMeasurement() {
    // TODO Auto-generated method stub
    return 0;
  }
}
