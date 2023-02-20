// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.drive;

public class drivex extends CommandBase {
  
  // variables
  private final drive m_drivetrain;
  private final CommandXboxController m_controller;
  
  /** Creates a new drivex. */
  public drivex(drive drive, CommandXboxController xbox) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive;
    m_controller = xbox;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.setDefaultCommand(
      new driveplease(m_drivetrain, m_controller::getLeftY, m_controller::getRightY)
    );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setDefaultCommand(null);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
