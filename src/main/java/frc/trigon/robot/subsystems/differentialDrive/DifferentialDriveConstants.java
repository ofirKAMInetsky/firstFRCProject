package frc.trigon.robot.subsystems.differentialDrive;

import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;

public class DifferentialDriveConstants {
    private static final int
            FRONT_LEFT_MOTOR_ID = 0,
            FRONT_RIGHT_MOTOR_ID = 1,
            BACK_LEFT_MOTOR_ID = 2,
            BACK_RIGHT_MOTOR_ID = 3;

    private static final InvertedValue INVERTED_VALUE = InvertedValue.Clockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Brake;

    static final TalonFX
            FRONT_LEFT_MOTOR = new TalonFX(FRONT_LEFT_MOTOR_ID),
            FRONT_RIGHT_MOTOR = new TalonFX(FRONT_RIGHT_MOTOR_ID),
            BACK_LEFT_MOTOR = new TalonFX(BACK_LEFT_MOTOR_ID),
            BACK_RIGHT_MOTOR = new TalonFX(BACK_RIGHT_MOTOR_ID);

    static {

    }



}
