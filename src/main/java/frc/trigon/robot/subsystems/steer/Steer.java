package frc.trigon.robot.subsystems.steer;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.*;

import java.util.Date;
import java.util.function.Supplier;

public class
Steer extends SubsystemBase {

    private final static Steer INSTANCE = new Steer();

    public static Steer getInstance() {
        return INSTANCE;
    }

    private final TalonFX motor = SteerConstants.MOTOR;

    private Steer() {
    }

    public CommandBase getSetTargetAngleCommand(Supplier<Double> angleDegrees){
        return new FunctionalCommand(
                () -> {},
                () -> setTargetAngle(angleDegrees.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }
    public CommandBase getSetTargetAngleCommand(double angleDegrees){
        return new FunctionalCommand(
                () -> {},
                () -> setTargetAngle(angleDegrees),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }
    public CommandBase getTargetAngleCommand(){
        return new SequentialCommandGroup(
                getSetTargetAngleCommand(90).withTimeout(3),
                getSetTargetAngleCommand(180).withTimeout(3),
                getSetTargetAngleCommand(0));

    }

    private void setTargetAngle(double angleDegrees) {
        double systemRevolution = angleDegrees / 360;
        double motorRevolution = systemRevolution * SteerConstants.GEAR_RATIO;
        PositionVoltage request = new PositionVoltage(motorRevolution);
        motor.setControl(request);
    }

    private void stop() {
        motor.stopMotor();
    }
}

