// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// packages
package frc.robot.subsystems;

// imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shoot extends SubsystemBase {
  private final CANSparkMax motor1 = new CANSparkMax(9, MotorType.kBrushless);
  private final CANSparkMax motor2 = new CANSparkMax(11, MotorType.kBrushless);
  
  /** Creates a new shoot. */
  public shoot() {
    motor1.setInverted(false);
    motor1.setIdleMode(IdleMode.kBrake);
    motor2.setInverted(false);
    motor2.setIdleMode(IdleMode.kBrake);
  }

  // make this thing shoot
  public void makemeshoot(double mSpeed1, double mSpeed2) {
    motor1.set(mSpeed1);
    motor2.set(mSpeed2);
    
  }

  @Override
  // make this thing send value to dash
  public void periodic() {
    SmartDashboard.putNumber("1", motor1.getEncoder().getPosition()); 
    SmartDashboard.putNumber("2", motor2.getEncoder().getPosition());
    SmartDashboard.putNumber("1V", motor1.getEncoder().getVelocity());
    SmartDashboard.putNumber("2V", motor2.getEncoder().getVelocity());
    SmartDashboard.putNumber("Speed Percent 1", motor1.getAppliedOutput());
  }

  // get encoder values
  public double getEncoderValues(int motor) {
    double encoder;
    if(motor == 1) {
      encoder = motor1.getEncoder().getVelocity();
    } else if(motor == 2) {
      encoder = motor2.getEncoder().getVelocity();
    } else {
      encoder = 0;
      System.out.print("MOTOR DOES NOT EQUAL INTENDED VALUE, PLEASE SET TO 1 OR 2");
    }
    return encoder;
    
  }
}
