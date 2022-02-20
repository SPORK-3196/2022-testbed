// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake { //Made By Caputo

    public class SparkTest extends SubsystemBase {
  
        public CANSparkMax sparkMax3 = new CANSparkMax(15, MotorType.kBrushless);
        
      
        public RelativeEncoder sparkEncoder = sparkMax3.getEncoder();
        public PIDController sparkPIDController = new PIDController(5e-5, 1e-6, 0);
      
        public boolean xboxRightBumper;

       //runs intake sparkMax
        public void runSparks (double power) {
          if (xboxRightBumper(true))
            sparkMax3.set(power * -0.5);
 
        }
       //stops intake sparkMax
        public void stopSparks() {
          if (xboxRightBumper(false))
            sparkMax3.stopMotor();
          
        }
      
      
       /* @Override
        public void periodic() {
          // This method will be called once per scheduler run
          sparkVelocity = sparkEncoder.getVelocity();
      
          Encoder_RPM_Entry.setDouble(sparkVelocity);
      
          Encoder_MPH_Entry.setDouble( ((sparkVelocity * SparkWheelRadiusDiameter) * 60 * Math.PI) / 63360 );
        }
        */
      
        @Override
        public void simulationPeriodic() {
          // This method will be called once per scheduler run during simulation
        }

    }

    public boolean xboxRightBumper(boolean b) {
        return false;
    }
}
