/**
 * Represents a Child passenger, extending the Passenger class.
 * Adds additional features specific to child passengers, such as guardian details and special requirements.
 * @author Hasini Vijay Inbasri
 */
public class Child extends Passenger {
    private String guardianName; // Name of the child's guardian

    /**
     * Creates a new Child passenger instance.
     * @param name Name of the child.
     * @param passportNumber Passport number of the child.
     * @param ticketNumber Ticket number of the child.
     * @param assignedFlight Flight assigned to the child.
     * @param age Age of the child.
     * @param guardianName Name of the guardian.
     */
    public Child(String name, String passportNumber, String ticketNumber, String assignedFlight, int age, String guardianName) {
        super(name, passportNumber, assignedFlight, ticketNumber, age);
        this.guardianName = guardianName;
    }

    /**
     * Gets the name of the child's guardian.
     * @return Guardian's name.
     * @author Hasini Vijay Inbasri
     */
    public String getGuardianName() {
        return guardianName;
    }

    /**
     * Determines if the child requires special toys based on their age.
     * @return A string indicating if special toys are needed.
     * @author Hasini Vijay Inbasri
     */
    public String requiresSpecialToys() {
        if (getAge() < 6) {
            return "Yes. The items will be provided since the child is under 6";
        } else {
            return "No. Your child is over the age limit so he/she would not be provided the things.";
        }
    }

    /**
     * Requests an activity kit for the child.
     * Prints a confirmation to the console.
     * @author Hasini Vijay Inbasri
     */
    public void requestActivityKit() {
        System.out.println("Activity kit requested for the child.");
    }

    /**
     * Retrieves the passenger information along with guardian details.
     * @return A string containing the passenger's information.
     * @author Hasini Vijay Inbasri
     */
    public String getPassengerInfo() {
        String passengerInfo = "";
        passengerInfo += super.getPassengerInfo();
        passengerInfo += "\nGuardian Name: " + getGuardianName();

        return passengerInfo;
    }
}
