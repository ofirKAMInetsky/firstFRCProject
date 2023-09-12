package frc.trigon.robot.subsystems.differentialDrive;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DifferentialDrive extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    private final static DifferentialDrive INSTANCE = new DifferentialDrive();

    public static DifferentialDrive getInstance() {
        return INSTANCE;
    }

    private DifferentialDrive() {
    }

}

