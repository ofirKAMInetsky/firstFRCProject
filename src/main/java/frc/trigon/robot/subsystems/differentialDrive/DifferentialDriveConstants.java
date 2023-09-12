package frc.trigon.robot.subsystems.differentialDrive;

import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

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

    static MotorControllerGroup LEFT_MOTORS = new MotorControllerGroup(FRONT_LEFT_MOTOR, BACK_LEFT_MOTOR);
    static MotorControllerGroup RIGHT_MOTORS = new MotorControllerGroup(FRONT_RIGHT_MOTOR, BACK_RIGHT_MOTOR);


    static {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.Audio.BeepOnBoot = false;
        config.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;
        config.MotorOutput.Inverted = INVERTED_VALUE;
        BACK_RIGHT_MOTOR.getConfigurator().apply(config);
        BACK_LEFT_MOTOR.getConfigurator().apply(config);
        FRONT_RIGHT_MOTOR.getConfigurator().apply(config);
        FRONT_LEFT_MOTOR.getConfigurator().apply(config);
    }



}
