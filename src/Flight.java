import java.util.ArrayList;

/**
 * Represents a Flight, including details such as flight number, airline, origin, destination,
 * departure and arrival times, status, terminal number, and airport code.
 * Manages passengers and provides utilities for flight operations.
 * @author Hasini Vijay Inbasri
 */
public class Flight {
    private String flightNumber; // Unique identifier for the flight
    private String airline; // Airline operating the flight
    private String destination; // Destination of the flight
    private String origin; // Origin of the flight
    private String departureTime; // Scheduled departure time
    private String arrivalTime; // Scheduled arrival time
    private String status; // Current status of the flight
    private String terminalNumber; // Terminal from which the flight departs
    private String airportCode; // Code of the airport handling the flight
    private ArrayList<Passenger> passengers; // List of passengers on the flight

    /**
     * Creates a new Flight instance.
     * @param flightNumber Unique flight number.
     * @param airline Name of the airline.
     * @param origin Origin of the flight.
     * @param destination Destination of the flight.
     * @param departureTime Scheduled departure time.
     * @param arrivalTime Scheduled arrival time.
     * @param status Current flight status.
     * @param terminalNumber Terminal number of the flight.
     * @param airportCode Airport code.
     */
    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String arrivalTime, String status, String terminalNumber, String airportCode) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.terminalNumber = terminalNumber;
        this.airportCode = airportCode;
        this.passengers = new ArrayList<>();
    }

    /**
     * Gets the flight's current status.
     * @return A string describing the flight's status.
     */
    public String getFlightStatus() {
        return "Flight " + flightNumber + " status is " + status;
    }

    /**
     * Gets the airline operating the flight.
     * @return Airline name.
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Gets the destination of the flight.
     * @return Destination of the flight.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Gets the airport code associated with the flight.
     * @return Airport code.
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * Gets the terminal number of the flight.
     * @return Terminal number.
     */
    public String getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * Gets the origin of the flight.
     * @return Origin of the flight.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Gets the scheduled departure time.
     * @return Departure time.
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Gets the scheduled arrival time.
     * @return Arrival time.
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Delays the flight by updating its departure time and status.
     * @param newTime New departure time.
     */
    public void delayFlight(String newTime) {
        departureTime = newTime;
        status = "Delayed";
    }

    /**
     * Updates the flight's status.
     * @param newStatus New status of the flight.
     */
    public void updateStatus(String newStatus) {
        status = newStatus;
    }

    /**
     * Gets the flight number.
     * @return Flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Calculates the flight duration in hours based on departure and arrival times.
     * @return Flight duration in hours.
     */
    public double getFlightDurationInHours() {
        String[] depParts = departureTime.split(":");
        String[] arrParts = arrivalTime.split(":");

        int depHour = Integer.parseInt(depParts[0]);
        int depMinute = Integer.parseInt(depParts[1]);
        int arrHour = Integer.parseInt(arrParts[0]);
        int arrMinute = Integer.parseInt(arrParts[1]);

        int depTotalMinutes = depHour * 60 + depMinute;
        int arrTotalMinutes = arrHour * 60 + arrMinute;

        int differenceMinutes = arrTotalMinutes - depTotalMinutes;
        return differenceMinutes / 60.0;
    }

    /**
     * Provides instructions for when passengers should arrive at the terminal before departure.
     * @return A string advising passengers when to arrive.
     */
    public String timeToReachTerminal() {
        return "Make sure to return at least 2 hours before your flight's departure time: " + departureTime;
    }

    /**
     * Generates a detailed summary of the flight information.
     * @return A string containing the flight's details.
     */
    public String getFlightInfo() {
        String flightInfo = "";
        flightInfo += "========================\n";
        flightInfo += "Your Flight Details\n";
        flightInfo += "========================\n";
        flightInfo += "Flight Number: " + getFlightNumber() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += "Origin: " + getOrigin() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += "Destination: " + getDestination() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += "Departure Time: " + getDepartureTime() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += "Arrival Time: " + getArrivalTime() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += "Flight Duration (Hours): " + getFlightDurationInHours() + "\n";
        flightInfo += "------------------------\n";
        flightInfo += timeToReachTerminal();
        flightInfo += "\n========================";

        return flightInfo;
    }

    /**
     * Finds a passenger by their name.
     * @param passengerName Name of the passenger to search for.
     * @return The Passenger object if found, otherwise null.
     */
    public Passenger findPassengerByName(String passengerName) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(passengerName)) {
                return passenger;
            }
        }
        return null;
    }

    /**
     * Finds a passenger by their ticket number.
     * @param ticketNumber Ticket number of the passenger to search for.
     * @return The Passenger object if found, otherwise null.
     */
    public Passenger findPassengerByTicketNumber(String ticketNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getTicketNumber().equalsIgnoreCase(ticketNumber)) {
                return passenger;
            }
        }
        return null;
    }

    /**
     * Removes a passenger from the flight using their ticket number.
     * @param ticketNumber Ticket number of the passenger to remove.
     * @return True if the passenger is successfully removed, otherwise false.
     */
    public boolean removePassenger(String ticketNumber) {
        Passenger passenger = findPassengerByTicketNumber(ticketNumber);

        if (passenger != null && passenger.cancelBooking() == true) {
            passengers.remove(passenger);
            return true;
        }

        return false;
    }

    /**
     * Adds a passenger to the flight.
     * @param passenger The Passenger object to add.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}
