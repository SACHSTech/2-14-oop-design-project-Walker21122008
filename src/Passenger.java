/**
 * Represents a Passenger, including details such as name, age, passport number, ticket number,
 * assigned flight number, check-in status, and contact information.
 * Provides methods for managing passenger operations like booking cancellation, check-in, and assistance requests.
 * @author Hasini Vijay Inbasri
 */
public class Passenger {
    private String name; // Name of the passenger
    private int age; // Age of the passenger
    private String passportNumber; // Passport number of the passenger
    private String ticketNumber; // Ticket number of the passenger
    private String assignedFlightNumber; // Flight number assigned to the passenger
    private boolean checkInStatus; // Check-in status of the passenger
    private long contactNumber; // Contact number of the passenger

    /**
     * Creates a new Passenger instance.
     * @param name Name of the passenger.
     * @param passportNumber Passport number of the passenger.
     * @param assignedFlightNumber Flight number assigned to the passenger.
     * @param ticketNumber Ticket number of the passenger.
     * @param age Age of the passenger.
     */
    public Passenger(String name, String passportNumber, String assignedFlightNumber, String ticketNumber, int age) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.ticketNumber = ticketNumber;
        this.assignedFlightNumber = assignedFlightNumber;
        this.age = age;
        this.checkInStatus = false;
        this.contactNumber = 0;
    }

    /**
     * Gets the passenger's ticket number.
     * @return Ticket number as a string.
     * @author Hasini Vijay Inbasri
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Gets the passenger's age.
     * @return Age as an integer.
     * @author Hasini Vijay Inbasri
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the passenger's passport number.
     * @return Passport number as a string.
     * @author Hasini Vijay Inbasri
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Gets the flight number assigned to the passenger.
     * @return Assigned flight number as a string.
     * @author Hasini Vijay Inbasri
     */
    public String getAssignedFlightNumber() {
        return assignedFlightNumber;
    }

    /**
     * Gets the passenger's name.
     * @return Name as a string.
     * @author Hasini Vijay Inbasri
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the passenger has checked in.
     * @return True if the passenger has checked in, false otherwise.
     * @author Hasini Vijay Inbasri
     */
    public boolean getCheckInStatus() {
        return checkInStatus;
    }

    /**
     * Updates the passenger's contact number if valid.
     * @param contactNumber The new contact number.
     * @param passenger The passenger whose contact info is being updated.
     * @author Hasini Vijay Inbasri
     */
    public void updateContactNumber(long contactNumber, Passenger passenger) {
        if (contactNumber >= 1000000000L && contactNumber <= 9999999999L) {
            passenger.updateContactNumber(contactNumber);
            System.out.println("Helpy has added your contact info! Yippee!");
        } else {
            System.out.println("Helpy says that it is an invalid contact number! Please enter an actual contact info!");
        }
    }

    /**
     * Gets the contact number of the passenger.
     * @return Contact number as a long.
     * @author Hasini Vijay Inbasri
     */
    public long getContactNumber() {
        return contactNumber;
    }

    /**
     * Cancels the booking if the passenger hasn't checked in and has an assigned flight.
     * @return True if the booking is successfully canceled, false otherwise.
     * @author Hasini Vijay Inbasri
     */
    public boolean cancelBooking() {
        if (assignedFlightNumber != null) {
            if (!checkInStatus) {
                System.out.println("Booking cancelled.");
                assignedFlightNumber = null;
                return true;
            }
        }
        System.out.println("You do not have an assigned flight or you have already checked in.");
        return false;
    }

    /**
     * Checks in the passenger for the assigned flight.
     * @return A string indicating the check-in status.
     * @author Hasini Vijay Inbasri
     */
    public String checkIn() {
        if (assignedFlightNumber != null && !assignedFlightNumber.isEmpty()) {
            if (!checkInStatus) {
                checkInStatus = true;
                return "Checked in for flight " + assignedFlightNumber;
            } else {
                return "You have already checked in.";
            }
        } else {
            return "No flight to check in. Please book a flight first.";
        }
    }

    /**
     * Updates the contact number of the passenger.
     * @param contactNumber New contact number.
     * @author Hasini Vijay Inbasri
     */
    public void updateContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Requests special assistance for the passenger.
     * @param serviceType Type of assistance requested.
     * @author Hasini Vijay Inbasri
     */
    public void requestSpecialAssistance(String serviceType) {
        System.out.println("Special assistance requested: " + serviceType);
        System.out.println("An assistant has been sent your way!");
    }

    /**
     * Retrieves the passenger's information in a formatted string.
     * @return A string containing the passenger's details.
     * @author Hasini Vijay Inbasri
     */
    public String getPassengerInfo() {
        String passengerInfo = "";
        passengerInfo += "Name: " + getName();
        passengerInfo += "\nPassport Number: " + getPassportNumber();
        passengerInfo += "\nFlight Number: " + getAssignedFlightNumber();
        passengerInfo += "\nTicket Number: " + getTicketNumber();
        passengerInfo += "\nCheck-in Status: " + getCheckInStatus();
        passengerInfo += "\nContact Number: " + getContactNumber();
        return passengerInfo;
    }
}
