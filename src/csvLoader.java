import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class csvLoader {
    private static ArrayList<Airport> airports = new ArrayList<>();
    private static ArrayList<Terminal> terminals = new ArrayList<>();
    private static ArrayList<Flight> flights = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();
    
    public static ArrayList<Airport> loadAirportsFromCSV(String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" - ");
            String airportName = data[0];
            String code = data[1];
            String location = data[2];

            Airport airport = new Airport(airportName, location, code);
            airports.add(airport);
        }
        return airports;
    }

    public static ArrayList<Terminal> loadTerminalsFromCSV(String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] data = line.split(",");
            String terminalNumber = data[0];
            int capacity = Integer.parseInt(data[1]);
            String airportCode = data[2];
            String type = data[3];

            switch (type) {
                case "International":
                    boolean customsAvailable = Boolean.parseBoolean(data[4]);
                    InternationalTerminal international = new InternationalTerminal(terminalNumber, capacity, airportCode, type, customsAvailable);
                    terminals.add(international);
                    findAirportByCode(airportCode).addTerminal(international);
                    break;
                case "Domestic":
                    String domesticCarrier = data[5];
                    DomesticTerminal domestic = new DomesticTerminal(terminalNumber, capacity, airportCode, type, domesticCarrier);
                    terminals.add(domestic);
                    findAirportByCode(airportCode).addTerminal(domestic);
                    break;
            }
        }
        return terminals;
    }

    public static ArrayList<Flight> loadFlightsFromCSV(String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(" - ");
            String flightNumber = data[0];
            String airlinesName = data[1];
            String origin = data[2];
            String destination = data[3];
            String departureTime = data[4];
            String arrivalTime = data[5];
            String status = data[6];
            String terminalNumber = data[7];
            String airportCode = data[8];

            Flight flight = new Flight(flightNumber, airlinesName, origin, destination, departureTime, arrivalTime, status, terminalNumber, airportCode);
            
            Terminal terminal = findTerminal(terminalNumber,airportCode);

            if (terminal != null && terminal.getAirportCode().equalsIgnoreCase(airportCode)) {
                terminal.addFlight(flight);
                flights.add(flight);
            }            
        }
        return flights;
    }

    public static ArrayList<Passenger> loadPassengersFromCSV(String csvFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] data = line.split(",");
            String name = data[0];
            String passportNumber = data[1];
            String ticketNumber = data[2];
            String assignedFlight = data[3];
            int age = Integer.parseInt(data[4]);

            Passenger passenger = new Passenger(name, passportNumber, assignedFlight, ticketNumber, age);

            Flight flight = findFlightByFlightNumber(assignedFlight);
            if (flight != null) {
                flight.addPassenger(passenger);
                passengers.add(passenger);
            } 
            
        }
        return passengers;
    }

    public static Airport findAirportByCode(String code){
        for(Airport airport : airports){
            if (airport.getAirportCode().equalsIgnoreCase(code)){
                return airport;
            }
        }
        return null;
    }

    public static Terminal findTerminal(String terminalNumber, String airportCode){
        for(Terminal terminal : terminals){
            if (terminal.getTerminalNumber().equalsIgnoreCase(terminalNumber) 
                && terminal.getAirportCode().equalsIgnoreCase(airportCode)){
                return terminal;
            }
        }
        return null;

    }

    public static Flight findFlightByFlightNumber(String flightNumber){
        for(Flight flight : flights){
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)){
                return flight;
            }
        }
        return null;

    }

    public static Airport findAirportByDetail(String option, String detail) {
        for (Airport airport : airports) {
            if (option.equalsIgnoreCase("Name") && airport.getAirportName().equalsIgnoreCase(detail)){
                return airport;
            } 
            if (option.equalsIgnoreCase("Code") && airport.getAirportCode().equalsIgnoreCase(detail)){
                return airport;
            }
        }
        return null;
    }
    
}
