package frc.trigon.robot.subsystems.collector;


import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Collector extends SubsystemBase {

    private final static Collector INSTANCE = new Collector();

    public static Collector getInstance() {
        return INSTANCE;
    }

    private final TalonFX motor = CollectorConstants.MOTOR;

    private Collector() {
    }

    public CommandBase getCollectCommand() {
        return new StartEndCommand(
                this::collect,
                this::stop,
                this
        );
    }

    public CommandBase getEjectCommand() {
        return new StartEndCommand(
                this::eject,
                this::stop,
                this
        );
    }
    public CommandBase getCollectWaitEjectWait() {
        return new SequentialCommandGroup(
                getCollectCommand().withTimeout(3),
                getEjectCommand().withTimeout(3));

    }

    public CommandBase getCollectThenEjectCommand() {
        return getCollectCommand().andThen(getEjectCommand());
    }

    private void eject() {
        motor.setVoltage(CollectorConstants.EJECT_VOLTAGE);
    }

    private void collect() {
        motor.setVoltage(CollectorConstants.COLLECT_VOLTAGE);
    }

    private void stop() {
        motor.stopMotor();
    }
}