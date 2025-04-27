import java.util.ArrayList;

public class Terminal {
    private String terminalNumber;
    private int capacity;
    private String type;
    private String airportCode;
    private ArrayList<Flight> flights;

    public Terminal(String terminalNumber, int capacity, String airportCode, String type) {
        this.terminalNumber = terminalNumber;
        this.capacity = capacity;
        this.flights = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public String getType(){
        return type;
    }

    public String getTerminalNumber(){
        return terminalNumber;
    }

    public String getTerminalInfo() {
        return "Terminal " + terminalNumber + ", Capacity: " + capacity;
    }

    public ArrayList<Flight> listFlights() {
        return flights;
    }

    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null; 
    }

    public String displayAllFlights() {
        StringBuilder flightDetails = new StringBuilder();
        for (Flight flight : flights) {
            flightDetails.append(flight.getFlightNumber())
                         .append(" - Destination: ")
                         .append(flight.getDestination())
                         .append(", Departure Time: ")
                         .append(flight.getDepartureTime())
                         .append("\n");
        }
        return flightDetails.toString();
    }

    public String checkTerminalAvailability() {
        if (flights.size() < capacity) {
            return "Terminal has available capacity.";
        } else {
            return "Terminal is at full capacity.";
        }
    }



}

