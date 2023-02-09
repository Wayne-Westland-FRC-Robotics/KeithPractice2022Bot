// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drive;

public class driveplease extends CommandBase {
  
  // variables
  private final drive m_drive;
  private final DoubleSupplier leftSpeed;
  private final DoubleSupplier rightSpeed;
  
  /** Creates a new driveplease. */
  public driveplease(drive drivetrain, DoubleSupplier leftJoy, DoubleSupplier rightJoy) {
    m_drive = drivetrain;
    leftSpeed = leftJoy;
    rightSpeed = rightJoy;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.makeMeDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble() * -1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.makeMeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
