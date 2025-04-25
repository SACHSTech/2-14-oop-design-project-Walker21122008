import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private int terminalNumber;
    private boolean isThereSeat;
    private String gateType;
    private List<Gate> gates = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();

    public Terminal(int terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public int getTerminalNumber() {
        return terminalNumber;
    }

    public void addGate(Gate gate) {
        this.gates.add(gate);
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

}