import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Airport> airports = new ArrayList<>();
    private static ArrayList<Terminal> terminals = new ArrayList<>();
    private static ArrayList<Flight> flights = new ArrayList<>();
    private static ArrayList<Passenger> passengers = new ArrayList<>();
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        setUpTheAirportsTerminalsFlightsPassengers();

        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! Welcome to AirTravel Buddy! Your personal travel helpy!");
        System.out.println("          __|__");
        System.out.println("   --@--@--(_)--@--@--");
        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("[____________________]");
        System.out.println(" \\       ----       /");
        System.out.println("  \\________________/");

        mainMenu();

    }

    private static void mainMenu() throws IOException{

        System.out.println("Please choose your airport or choose to view all:");
        System.out.println("1. By Code");
        System.out.println("2. By Name");
        System.out.println("3. View all airports!");
        System.out.println("4. Exit");

        String input = reader.readLine();

        Airport airport;

        switch (input) {
            case "1":
                System.out.print("Enter airport code: ");
                String code = reader.readLine();
                airport = findAirportByDetail("Code", code);
                if (airport == null) {
                    System.out.println("Airport not found. Please try again.");
                } else {
                    airportHelpMenu(airport);
                }
                
                break;

            case "2":
                System.out.print("Enter airport name: ");
                String name = reader.readLine();
                airport = findAirportByDetail("Name", name);
                if (airport == null) {
                    System.out.println("Airport not found. Please try again.");
                } else {
                    airportHelpMenu(airport);
                }
                break;

            case "3":
                System.out.println("List of Airports:");
                for (Airport a : airports) {
                    System.out.println(a.getAirportInfo());
                }
                break;

            case "4":
                System.out.println("Thank you for using AirTravel Buddy!");
                return;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
        mainMenu();
    }

    private static void airportHelpMenu(Airport airport) throws IOException {
        System.out.println("Hello Passenger! Your airport details are the follows: ");
        System.out.println(airport.getAirportInfo());
            System.out.println("\nAirport Menu:");
            System.out.println("1. Find Flight by Passenger Name");
            System.out.println("2. Find Flight by Flight Number");
            System.out.println("3. List all terminals");
            System.out.println("4. List all flights");
            System.out.println("5. Go Back to Previous Menu");

            System.out.print("Please choose an option: ");
            String choice = reader.readLine();
            Flight flight;
            
            switch (choice) {
                case "1":
                    flight = findFlightByPassengerName(airport);
                    if (flight!= null) flightHelpMenu(flight);
                    break;

                case "2":
                    flight = findFlightByFlightNumber(airport);
                    if (flight!= null) flightHelpMenu(flight);
                    break;
                case "3":
                    for (Terminal terminal : airport.getTerminals()) {
                        System.out.println(terminal.getTerminalInfo() + ", " + terminal.checkTerminalCapacity());
                    }                 
                    break;
                case "4":
                    for (Terminal terminal : airport.getTerminals()) {
                        System.out.println("Flights in Terminal :" + terminal.getTerminalNumber());
                        for (Flight f: terminal.getAllFlights()) {
                            System.out.println(f.getFlightInfo());
                        }
                        System.out.println("\n\n");
                    }
                    break;
                case "5":
                    System.out.println("Returning to previous menu");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            airportHelpMenu(airport);
    }

    private static Flight findFlightByPassengerName(Airport airport) throws IOException {
        System.out.println("Dear Passenger, Please enter your name:");
        String name = reader.readLine();

        for (Terminal terminal : airport.getTerminals()) {
            for (Flight flight : terminal.getAllFlights()) {
                if (flight.findPassengerByName(name) != null) {
                    return flight;
                }
            }
        }
        System.out.println("Passenger not found assigned to any flights in this airport. Please try again.");
        return null;
    }

    private static Flight findFlightByFlightNumber(Airport airport) throws IOException {
        System.out.println("Please enter your flight code:");
        String flightNumber = reader.readLine();

        for (Terminal terminal : airport.getTerminals()) {
            for (Flight flight : terminal.getAllFlights()) {
                if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                    return flight;
                }
            }
        }
        System.out.println("Flight with provided flight number not found. Please try again.");
        return null;
    }

    private static void flightHelpMenu(Flight flight) throws IOException {
            System.out.println("\nFlight Help Options for flight number (" + flight.getFlightNumber() + "):");
            System.out.println("1. Show Flight Details");
            System.out.println("2. Find Passenger By Ticket Number");
            System.out.println("3. Go Back");

            System.out.print("Please choose an option: ");
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    System.out.println(flight.getFlightInfo());                  
                    break;

                case "2":
                    System.out.println("Dear Passenger, Please enter your ticket number:");
                    String ticketNumber = reader.readLine();
                    Passenger passenger = flight.findPassengerByTicketNumber(ticketNumber);
                    if (passenger != null) { 
                        passengerHelpMenu(passenger, flight); 
                    }
                    else {
                        System.out.println("Passenger not found; Please try again");
                    }
                    break;

                case "3":
                    System.out.println("Returning to previous menu");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            flightHelpMenu(flight);
    }

    public static void passengerHelpMenu(Passenger passenger, Flight flight) throws IOException{
        System.out.println("\nPassenger Help Options for passenger name (" + passenger.getName() + "):");

        System.out.println("1. Cancel Booking");
        System.out.println("2. Check In");
        System.out.println("3. Check Flight Status");
        System.out.println("4. Update Passenger Contact Info");
        System.out.println("5. Request special assistance");
        System.out.println("6. Passenger Info");
        System.out.println("7. Go Back");

        System.out.print("Please choose an option: ");
        String choice = reader.readLine();

        switch (choice) {
            case "1":
                flight.removePassenger(passenger.getTicketNumber());
                return;

            case "2":
                passenger.checkIn();
                break;

            case "3":
                System.out.println(flight.getFlightStatus());
                break;
            
            case "4":
                System.out.println("Dear Passenger, Please enter your new contact number:");
                String contactNumber = reader.readLine();
                passenger.updateContactNumber(contactNumber);
                break;

            case "5":
                System.out.println("Dear Passenger, Please provide your special request service type:");
                String serviceType = reader.readLine();
                passenger.requestSpecialAssistance(serviceType);
                break;

            case "6":
                System.out.println(passenger.getPassengerInfo());
                return;

            case "7":
                System.out.println("Returning to previous menu");
                return;

            default:
                System.out.println("Invalid option. Please try again.");
                flightHelpMenu(flight);
        }
        passengerHelpMenu(passenger, flight);

    }

    private static void setUpTheAirportsTerminalsFlightsPassengers() throws IOException {
        loadAirportsFromCSV("src/Airport.csv");
        loadTerminalsFromCSV("src/Terminal.csv");
        loadFlightsFromCSV("src/Flight.csv");
        loadPassengersFromCSV("src/Passengers.csv");
    }
    
    

    private static void loadAirportsFromCSV(String csvFile) throws IOException {
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
        reader.close();
    }

    private static void loadTerminalsFromCSV(String csvFile) throws IOException {
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
        reader.close();
    }

    private static void loadFlightsFromCSV(String csvFile) throws IOException {
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
        reader.close();
    }

    private static void loadPassengersFromCSV(String csvFile) throws IOException {
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
        reader.close();
    }

    private static Airport findAirportByCode(String code){
        for(Airport airport : airports){
            if (airport.getAirportCode().equalsIgnoreCase(code)){
                return airport;
            }
        }
        return null;

    }

    private static Terminal findTerminal(String terminalNumber, String airportCode){
        for(Terminal terminal : terminals){
            if (terminal.getTerminalNumber().equalsIgnoreCase(terminalNumber) 
                && terminal.getAirportCode().equalsIgnoreCase(airportCode)){
                return terminal;
            }
        }
        return null;

    }

    private static Flight findFlightByFlightNumber(String flightNumber){
        for(Flight flight : flights){
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)){
                return flight;
            }
        }
        return null;

    }

    private static Airport findAirportByDetail(String option, String detail) {
        for (Airport airport : airports) {
            if (option.equalsIgnoreCase("Name") && airport.getAirportName().equalsIgnoreCase(detail)) return airport;
            if (option.equalsIgnoreCase("Code") && airport.getAirportCode().equalsIgnoreCase(detail)) return airport;
        }
        return null;
    }

}
