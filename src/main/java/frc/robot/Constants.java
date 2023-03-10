// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kDriverJoystickPortR = 1;
    public static final int kDriverJoystickPortL = 2;
  }

  public static class PIDConstants {
    public static final double KP_FLYWHEEL = 0.00046628;
    public static final double KI_FLYWHEEL = 0;
    public static final double KD_FLYWHEEL = 0;
    public static final double KS_FLYWHEEL = 0.0001359;
    public static final double KV_FLYWHEEL = 0.00013046;
    public static final double KA_FLYWHEEL = 0.00021252;

  }
}
