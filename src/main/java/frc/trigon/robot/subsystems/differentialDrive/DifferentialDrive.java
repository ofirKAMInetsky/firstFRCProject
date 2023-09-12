package frc.trigon.robot.subsystems.differentialDrive;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;


public class DifferentialDrive extends SubsystemBase {
    private final static DifferentialDrive INSTANCE = new DifferentialDrive();
    private final MotorControllerGroup leftMotors = DifferentialDriveConstants.LEFT_MOTORS;
    private final MotorControllerGroup rightMotors = DifferentialDriveConstants.RIGHT_MOTORS;
    private final edu.wpi.first.wpilibj.drive.DifferentialDrive motors = new edu.wpi.first.wpilibj.drive.DifferentialDrive(leftMotors, rightMotors);

    public static DifferentialDrive getInstance() {
        return INSTANCE;
    }

    private DifferentialDrive() {
    }

    /**
     * Creates a command that drives the differential drive in arcade mode.
     *
     * @param powerSupplier    the forward power supplier
     * @param rotationSupplier the rotation power supplier
     * @return the command
     */
    public CommandBase getArcadeDriveCommand(Supplier<Double> powerSupplier, Supplier<Double> rotationSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> arcadeDrive(powerSupplier.get(), rotationSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates the command that drives the differential drive in tank mode.
     *
     * @param leftPowerSupplier  the left power supplier
     * @param rightPowerSupplier the right power supplier
     * @return return the command
     */
    public CommandBase getTankDriveCommand(Supplier<Double> leftPowerSupplier, Supplier<Double> rightPowerSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> tankDrive(leftPowerSupplier.get(), rightPowerSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Creates a command that drives the differential drive in curvature mode.
     *
     * @param powerSupplier            the forward power supplier
     * @param rotationSupplier         the rotation power supplier
     * @param allowTurnInPlaceSupplier a supplier for turning in place
     * @return the command
     */
    public CommandBase getCurvatureDriveCommand(Supplier<Double> powerSupplier, Supplier<Double> rotationSupplier, Supplier<Boolean> allowTurnInPlaceSupplier) {
        return new FunctionalCommand(
                () -> {
                },
                () -> curvatureDrive(powerSupplier.get(), rotationSupplier.get(), allowTurnInPlaceSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void curvatureDrive(double power, double rotation, boolean allowTurnInPlace) {
        motors.curvatureDrive(power, rotation, allowTurnInPlace);
    }

    private void arcadeDrive(double power, double rotation) {
        motors.arcadeDrive(power, rotation);
    }

    private void tankDrive(double leftPower, double rightPower) {
        motors.tankDrive(leftPower, rightPower);
    }

    private void stopLeftMotors() {
        leftMotors.stopMotor();
    }

    private void stopRightMotors() {
        rightMotors.stopMotor();
    }

    private void stop() {
        stopLeftMotors();
        stopRightMotors();
    }
}
