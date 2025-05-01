import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Airport with its details such as name, location, and code.
 * Manages terminals and provides various utility methods for airport operations.
 * @author Hasini Vijay Inbasri
 */
public class Airport {
    private String name; // Name of the airport
    private String location; // Location of the airport
    private String code; // Airport code
    private ArrayList<Terminal> terminals; // List of terminals in the airport

    /**
     * Creates a new Airport instance.
     * @param name Name of the airport.
     * @param location Location of the airport.
     * @param code Airport code.
     */
    public Airport(String name, String location, String code) {
        this.name = name;
        this.location = location;
        this.code = code;
        this.terminals = new ArrayList<>();
    }

    /**
     * Searches for a flight by its flight number.
     * @param flightNumber The flight number to search for.
     * @return The Flight object if found, otherwise null.
     */
    public Flight searchFlight(String flightNumber) {
        for (Terminal terminal : terminals) {
            for (Flight flight : terminal.getAllFlights()) {
                if (flight.getFlightNumber().equals(flightNumber)) {
                    return flight;
                }
            }
        }
        return null; 
    }

    /**
     * Retrieves a list of all terminals in the airport.
     * @return A list of Terminal objects.
     */
    public List<Terminal> getTerminals() {
        return terminals;
    }

    /**
     * Gets the name of the airport.
     * @return Airport name.
     */
    public String getAirportName() {
        return name;
    }


    /**
     * Gets the code of the airport.
     * @return Airport code.
     */
    public String getAirportCode() {
        return code;
    }

    /**
     * Gets the location of the airport.
     * @return Airport location.
     */
    public String getAirportLocation() {
        return location;
    }

    /**
     * Counts the total number of flights across all terminals in the airport.
     * @return Total number of flights.
     */
    public int getFlightCount() {
        int count = 0;
        for (Terminal terminal : terminals) {
            count += terminal.getAllFlights().size();
        }
        return count;
    }

    /**
     * Adds a terminal to the airport.
     * @param terminal The Terminal object to be added.
     */
    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);
    }

    /**
     * Generates a brief description of the airport.
     * @return A string containing airport information.
     */
    public String getAirportInfo() {
        String airportInfo = getAirportName() + " (" + getAirportCode() + ") - " + getAirportLocation();
        return airportInfo;
    }
}
