package frc.trigon.robot.subsystems.turret;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;
import edu.wpi.first.math.controller.PIDController;

public class TurretConstants {
    private static int MOTOR_ID = 0;
    private static final InvertedValue INVERTED_VALUE = InvertedValue.Clockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Brake;
    static final TalonFX MOTOR = new TalonFX(MOTOR_ID);
    private static final double
            P = 8.4,
            I = 0,
            D = 0;
    static final PIDController PID_CONTROLLER = new PIDController(P,I,D);
    static {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.Audio.BeepOnBoot = false;
        config.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        config.MotorOutput.Inverted = INVERTED_VALUE;
        MOTOR.getConfigurator().apply(config);
        PID_CONTROLLER.setSetpoint(0);

    }
}
