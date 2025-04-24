import java.util.ArrayList;
import java.util.List;

public class Airport{
    private String name;
    private List<Terminal> terminals;
    private List<Flight> flights;
    private String location;


    public Airport(String name, String location) {
        this.name = name;
        this.terminals = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.location = location;

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
}