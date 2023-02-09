// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shoot;
import frc.robot.Constants.PIDConstants;;

public class PID extends CommandBase {
  
  // variables
  private final shoot shootPID;
  private final double mSpeed;
  PIDController pid = new PIDController(
    PIDConstants.KP_FLYWHEEL, PIDConstants.KI_FLYWHEEL, PIDConstants.KD_FLYWHEEL);
  private double encoder1;
  private double encoder2;
  private final int motorNum;
  SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(
    PIDConstants.KS_FLYWHEEL, PIDConstants.KV_FLYWHEEL, PIDConstants.KA_FLYWHEEL);
  
  /** Creates a new PID. */
  public PID(shoot PISHOOT, double RPM, int MOTOR) {
    shootPID = PISHOOT;
    mSpeed = RPM;
    motorNum = MOTOR;
    addRequirements(shootPID);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    encoder1 = shootPID.getEncoderValues(1);
    encoder2 = shootPID.getEncoderValues(2);
    shootPID.makemeshoot(
      (pid.calculate(encoder1, mSpeed) + feedforward.calculate(mSpeed * 1.56)),
      (pid.calculate(encoder2, mSpeed) + feedforward.calculate(mSpeed)));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shootPID.makemeshoot(0d, 0d);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
