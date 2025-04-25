import java.util.ArrayList;
import java.util.List;

public class Airport{
    private String name;
    private List<Terminal> terminals;
    private List<Flight> flights;
    private String location;
    private String amenities;


    public Airport(String name, String location, String amenities) {
        this.name = name;
        this.terminals = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.location = location;
        this.amenities = amenities;

    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void addTerminal(Terminal terminal) {
        this.terminals.add(terminal);
    }

    public void listTerminals(){
        for (Terminal terminal : terminals) {
            System.out.println("Still to add");
        }
    }

    public void listFlights(){
        for (Flight flight : flights) {
            System.out.println("Still to add");
        }
    }

    public String listAmenities() {
        return amenities;

    }

}