// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shoot;

public class shootme extends CommandBase {
  
  // variables
  private final shoot m_shoot;
  private final double speed1;
  private final double speed2;
  
  /** Creates a new shootme. */
  public shootme(shoot Shoot, double mSpeed1, double mSpeed2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shoot = Shoot;
    speed1 = mSpeed1;
    speed2 = mSpeed2;
    addRequirements(m_shoot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shoot.makemeshoot(speed1, speed2);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shoot.makemeshoot(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
