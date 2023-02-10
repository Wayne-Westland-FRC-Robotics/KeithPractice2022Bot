// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  
  // variables
  private final CANSparkMax one = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax two = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax three = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax four = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax five = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax six = new CANSparkMax(6, MotorType.kBrushless);
  
  private final MotorControllerGroup leftMo = new MotorControllerGroup(one, two, three);
  private final MotorControllerGroup rightMo = new MotorControllerGroup(four, five, six);
  public final DifferentialDrive difDrive = new DifferentialDrive(leftMo, rightMo);
  
  public boolean isBreak = false;

  /** Creates a new drive. */
  public drive() {
    
  }

  public void makeMeDrive(double leftSpeed, double rightSpeed) {
    difDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void brake() {
    if (isBreak == true) {
      one.setIdleMode(IdleMode.kBrake);
      two.setIdleMode(IdleMode.kBrake);
      three.setIdleMode(IdleMode.kBrake);
      four.setIdleMode(IdleMode.kBrake);
      five.setIdleMode(IdleMode.kBrake);
      six.setIdleMode(IdleMode.kBrake);
      isBreak = false;
    } else {
      one.setIdleMode(IdleMode.kCoast);
      two.setIdleMode(IdleMode.kCoast);
      three.setIdleMode(IdleMode.kCoast);
      four.setIdleMode(IdleMode.kCoast);
      five.setIdleMode(IdleMode.kCoast);
      six.setIdleMode(IdleMode.kCoast);
      isBreak = true;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("isCoast", isBreak);
  }
}
