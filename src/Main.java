import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Airport> airports = new ArrayList<>();
    private static List<Terminal> terminals = new ArrayList<>();
    private static List<Flight> flights = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setUpTheAirportsTerminalsFlightsPassengers();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! Welcome to AirTravel Buddy! Your personal travel helpy!");
        System.out.println("          __|__");
        System.out.println("   --@--@--(_)--@--@--");
        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("[____________________]");
        System.out.println(" \\       ----       /");
        System.out.println("  \\________________/");


        Airport airport = null;
        while (airport == null) {
            System.out.println("Please choose your airport or choose to view all:");
            System.out.println("1. By Code");
            System.out.println("2. By Location");
            System.out.println("3. By Name");
            System.out.println("4. View all airports!");
            String input = reader.readLine();

            switch (input) {
                case "1":
                    System.out.print("Enter airport code: ");
                    String code = reader.readLine();
                    airport = findAirportByDetail(code);
                    break;

                case "2":
                    System.out.print("Enter airport location: ");
                    String location = reader.readLine();
                    airport = findAirportByDetail(location);
                    break;

                case "3":
                    System.out.print("Enter airport name: ");
                    String name = reader.readLine();
                    airport = findAirportByDetail(name);
                    break;

                case "4":
                    System.out.println("List of Airports:");
                    for (Airport a : airports) {
                        System.out.println(a.getAirportName() + " (" + a.getAirportCode() + ") - " + a.getAirportLocation());
                    }
                    System.out.println("Please select an airport by entering its code, name, or location:");
                    String detail = reader.readLine();
                    airport = findAirportByDetail(detail);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            if (airport == null && !"4".equals(input)) {
                System.out.println("Airport not found. Please try again.");
            } else if (airport != null) {
                System.out.println("\nWelcome to " + airport.getAirportName() + " Airport, located in " + airport.getAirportLocation() + "!");
            }
        }

        showMainMenu(reader);
    }

    private static void showMainMenu(BufferedReader reader) throws IOException {
        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. View My Flight Details");
            System.out.println("2. Filter Options for Airport, Terminals, and Flights");
            System.out.println("3. Exit");

            System.out.print("Please choose an option: ");
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    findPersonalFlightInfo(reader);
                    break;
                case "2":
                    filterOptions();
                    break;
                case "3":
                    System.out.println("Thank you for using AirTravel Buddy! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void findPersonalFlightInfo(BufferedReader reader) throws IOException {
        System.out.println("Please enter your name:");
        String name = reader.readLine();

        Passenger passenger = findPassengerByName(name);
        if (passenger == null) {
            System.out.println("Passenger not found. Please try again.");
            return;
        } else {
            System.out.println("Hello, " + passenger.getName() + "!");
            Flight flight = findFlightByNumber(passenger.getAssignedFlight());
            if (flight != null) {
                flight.getFlightInfo();
            } else {
                System.out.println("You do not have a flight assigned.");
            }

            showSubMenu(reader, passenger);
        }
    }

    private static void showSubMenu(BufferedReader reader, Passenger passenger) throws IOException {
        while (true) {
            System.out.println("\nPersonal Options:");
            System.out.println("1. Check In");
            System.out.println("2. View Flight Hours");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Request Special Assistance");
            System.out.println("5. Go Back");

            System.out.print("Please choose an option: ");
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    System.out.println(passenger.checkIn());
                    break;
                case "2":
                    Flight flight = findFlightByNumber(passenger.getAssignedFlight());
                    if (flight != null) {
                        System.out.println("Flight hours: " + flight.flightDurationInHours());
                    } else {
                        System.out.println("No flight assigned to view flight hours.");
                    }
                    break;
                case "3":
                    passenger.cancelBooking();
                    break;
                case "4":
                    System.out.println("Enter type of special assistance needed:");
                    String serviceType = reader.readLine();
                    passenger.requestSpecialAssistance(serviceType);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void filterOptions() {//still to add
        System.out.println("Filtering options for Airport, Terminals, and Flights...");
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
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] data = line.split(" - ");
            String airportName = data[0];
            String location = data[1];
            String code = data[2];

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
                    break;
                case "Domestic":
                    String domesticCarrier = data[5];
                    DomesticTerminal domestic = new DomesticTerminal(terminalNumber, capacity, airportCode, type, domesticCarrier);
                    terminals.add(domestic);
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
            flights.add(flight);
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
            passengers.add(passenger);
        }
        reader.close();
    }

    private static Airport findAirportByDetail(String detail) {
        for (Airport airport : airports) {
            if (airport.getAirportName().equalsIgnoreCase(detail) ||
                airport.getAirportLocation().equalsIgnoreCase(detail) ||
                airport.getAirportCode().equalsIgnoreCase(detail)) {
                return airport;
            }
        }
        return null;
    }

    private static Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return passenger;
            }
        }
        return null;
    }

    private static Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}
