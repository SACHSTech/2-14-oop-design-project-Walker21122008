import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Terminal in an airport, which can manage flights and has specific details
 * such as terminal number, capacity, type, and associated airport code.
 * @author Hasini Vijay Inbasri
 */
public class Terminal {
    private String terminalNumber; // Terminal number identifier
    private int capacity; // Maximum capacity of the terminal
    private String type; // Type of the terminal
    private String airportCode; // Airport code associated with the terminal
    private ArrayList<Flight> flights; // List of flights assigned to this terminal

    /**
     * Creates a new Terminal instance.
     * @param terminalNumber The terminal number.
     * @param capacity The maximum capacity of the terminal.
     * @param airportCode The airport code associated with the terminal.
     * @param type The type of terminal 
     */
    public Terminal(String terminalNumber, int capacity, String airportCode, String type) {
        this.terminalNumber = terminalNumber;
        this.capacity = capacity;
        this.type = type;
        this.airportCode = airportCode;
        this.flights = new ArrayList<>();
    }

    

    /**
     * Gets the capacity of the terminal.
     * @return Terminal capacity.
     * @author Hasini Vijay Inbasri
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the type of the terminal.
     * @return Terminal type 
     * @author Hasini Vijay Inbasri
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the terminal number.
     * @return Terminal number.
     * @author Hasini Vijay Inbasri
     */
    public String getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * Gets the airport code associated with the terminal.
     * @return Airport code.
     * @author Hasini Vijay Inbasri
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * Retrieves basic information about the terminal.
     * @return A string containing terminal information.
     * @author Hasini Vijay Inbasri
     */
    public String getTerminalInfo() {
        return "Terminal " + terminalNumber + ", Capacity: " + capacity + ", type: " + type;
    }

    /**
     * Finds a flight by its flight number.
     * @param flightNumber The flight number to search for.
     * @return The Flight object if found, otherwise null.
     * @author Hasini Vijay Inbasri
     */
    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Adds a flight to the terminal if it matches the terminal's number and airport code.
     * @param flight The flight to be added.
     * @author Hasini Vijay Inbasri
     */
    public void addFlight(Flight flight) {
        if (flight != null 
            && terminalNumber.equals(flight.getTerminalNumber()) 
            && airportCode.equals(flight.getAirportCode())) {
            flights.add(flight);
        }
    }

    /**
     * Retrieves a list of all flights assigned to the terminal.
     * @return A list of Flight objects.
     * @author Hasini Vijay Inbasri
     */
    public List<Flight> getAllFlights() {
        return flights;
    }

    /**
     * Checks if the terminal has reached its capacity for flights.
     * @return A string indicating whether the terminal has available capacity or is full.
     * @author Hasini Vijay Inbasri
     */
    public String checkTerminalCapacity() {
        if (flights.size() < capacity) {
            return "Terminal has available capacity.";
        } else {
            return "Terminal is at full capacity.";
        }
    }
}
