package frc.trigon.robot.subsystems.collector;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;

public class CollectorConstants {
    private static final int MOTOR_ID = 0;
    private static final InvertedValue INVERTED = InvertedValue.Clockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Brake;
    public static final double
            EJECT_VOLTAGE = -6,
            COLLECT_VOLTAGE = 6;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);

    static {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.Audio.BeepOnBoot = false;
        config.MotorOutput.Inverted = INVERTED;
        config.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        MOTOR.getConfigurator().apply(config);
    }




}
