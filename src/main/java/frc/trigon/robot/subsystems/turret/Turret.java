package frc.trigon.robot.subsystems.turret;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.controls.VoltageOut;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Turret extends SubsystemBase {
    private final static Turret INSTANCE = new Turret();
    private final TalonFX motor = TurretConstants.MOTOR;
    private final PIDController pidController = TurretConstants.PID_CONTROLLER;

    private Turret() {

    }

    public static Turret getInstance() {
        return INSTANCE;
    }

    public CommandBase getAlignToReflectorCommand(Supplier<Double> reflectorPositionSupplier, Supplier<Boolean> hasTargetSupplier) {
        return new FunctionalCommand(
                () -> {},
                () -> alignToReflector(reflectorPositionSupplier.get(), hasTargetSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );

    }

    private void alignToReflector(double reflectorPosition, boolean hasTarget) {
        if (!hasTarget) {
            PositionVoltage request = new PositionVoltage(5);
            motor.setControl(request);
            return;
        }
        VoltageOut request = new VoltageOut(pidController.calculate(reflectorPosition));
        motor.setControl(request);
    }

    private void stop() {
        motor.stopMotor();
    }

}

