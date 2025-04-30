import java.util.ArrayList;
import java.util.List;


public class Airport {
    private String name;
    private String location;
    private String code;
    private ArrayList<Terminal> terminals;

    public Airport(String name, String location, String code) {
        this.name = name;
        this.location = location;
        this.code = code;
        this.terminals = new ArrayList<>();
    }

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

    public List<Terminal> getTerminals() {
        return terminals;
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

    public int getFlightCount() {
        int count = 0;
        for (Terminal terminal : terminals) {
            count += terminal.getAllFlights().size();
        }
        return count;
     }

    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);
    }

    public String getAirportInfo() {
        String airportInfo = getAirportName() + " (" + getAirportCode() + ") - " + getAirportLocation();
        return airportInfo;
    }


}
    
