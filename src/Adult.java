/**
 * Represents an Adult passenger, extending the Passenger class.
 * Includes additional features such as priority boarding and frequent flyer details.
 * @author Hasini Vijay Inbasri
 */
public class Adult extends Passenger {
    private boolean hasPriorityBoarding; // Indicates if the adult passenger has priority boarding privileges
    private String frequentFlyerNumber; // Frequent flyer number associated with the passenger

    /**
     * Creates a new Adult passenger instance.
     * @param name Name of the passenger.
     * @param passportNumber Passport number of the passenger.
     * @param ticketNumber Ticket number of the passenger.
     * @param assignedFlight Flight assigned to the passenger.
     * @param age Age of the passenger.
     * @param hasPriorityBoarding True if the passenger has priority boarding privileges, false otherwise.
     * @param frequentFlyerNumber Frequent flyer number of the passenger.
     */
    public Adult(String name, String passportNumber, String ticketNumber, String assignedFlight, int age, boolean hasPriorityBoarding, String frequentFlyerNumber) {
        super(name, passportNumber, ticketNumber, assignedFlight, age);
        this.hasPriorityBoarding = hasPriorityBoarding;
        this.frequentFlyerNumber = frequentFlyerNumber;
    }

    /**
     * Checks if the passenger has priority boarding privileges.
     * @return True if priority boarding is available, false otherwise.
     */
    public boolean isPriorityBoarding() {
        return hasPriorityBoarding;
    }

    /**
     * Gets the frequent flyer number of the passenger.
     * @return Frequent flyer number as a string.
     */
    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    /**
     * Determines if the passenger qualifies for an elderly seat based on their age.
     * @return A string indicating eligibility for an elderly seat.
     */
    public String getElderlySeat() {
        if (getAge() >= 60) {
            return "Yes, you will be getting the elderly seat";
        } else {
            return "No, you will not be getting the elderly seat";
        }
    }

    /**
     * Retrieves the passenger's information including frequent flyer details.
     * @return A string containing the passenger's information.
     */
    public String getPassengerInfo() {
        String passengerInfo = "";
        passengerInfo += super.getPassengerInfo();
        passengerInfo += "\nFreq Flyer Number: " + getFrequentFlyerNumber();

        return passengerInfo;
    }
}
