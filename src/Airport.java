import java.util.ArrayList;

public class Airport {
    private String name;
    private String location;
    private String code;
    private ArrayList<Terminal> terminals;
    private ArrayList<Flight> flights;

    public Airport(String name, String location, String code) {
        this.name = name;
        this.location = location;
        this.code = code;
    }

    public Flight searchFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null; 
    }

    public ArrayList<Flight> listAllFlights() {
        return flights;
    }

    public String getAirportName(){
        return name;
    }

    public String getAirportCode(){
        return code;
    }

    public String getAirportLocation(){
        return location;
    }

    public String getAirportInfo() {
        return "Airport: " + name + ", Location: " + location + ", Code: " + code;
    }

    public int getFlightCount() {
        return flights.size();
    }


    public Terminal findTerminalForFlight(Flight flight) {
        for (Terminal terminal : terminals) {
            if (listAllFlights().contains(flight)) {
                return terminal;
            }
        }
        return null;
    }

    public ArrayList<Terminal> filterTerminalsByType(String type) {
        ArrayList<Terminal> filteredTerminals = new ArrayList<>();
        for (Terminal terminal : terminals) {
            if (terminal.getType().equalsIgnoreCase(type)) {
                filteredTerminals.add(terminal);
            }
        }
        return filteredTerminals;
    }


    public String displayFilteredTerminalsByType(String type) {
        StringBuilder output = new StringBuilder("Filtered Terminals of type " + type + ":\n");
        ArrayList<Terminal> filteredTerminals = filterTerminalsByType(type);

        for (Terminal terminal : filteredTerminals) {
            output.append(terminal.getTerminalInfo()).append("\n");
        }

        return output.toString();
    }

}

