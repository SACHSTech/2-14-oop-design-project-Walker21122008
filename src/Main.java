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
        System.out.println("Hello! Welcome to AirTravel Buddy!");

        Passenger passenger = null;
        while (passenger == null) {
            System.out.println("Please enter your name to proceed:");
            String name = reader.readLine();
            passenger = findPassengerByName(name);

            if (passenger == null) {
                System.out.println("Passenger not found. Please try again.");
            } else {
                System.out.println("Welcome, " + passenger.getName() + "!");
            }
        }

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. View Airports");
            System.out.println("2. View Terminals at an Airport");
            System.out.println("3. Search Flights");
            System.out.println("4. View My Flight Details");
            System.out.println("5. Exit");
            String choice = reader.readLine();

            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    System.out.println("Thank you for using AirTravel Buddy!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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
            String FlightNumber = data[0];
            String airlinesName = data[1];
            String origin = data[2];
            String destination = data[3];
            String departureTime = data[4];
            String arrivalTime = data[5];
            String status = data[6];
            String terminalNumber = data[7];
            String airportCode = data[8];

            Flight flight = new Flight(FlightNumber, airlinesName, origin, destination, departureTime, arrivalTime, status, terminalNumber, airportCode);
            flights.add(flight);


        }
        reader.close();
    }

    public static void loadPassengersFromCSV(String csvFile) throws IOException {
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
            int age = Integer.parseInt(data[4]);

            if (age >= 18) {
                boolean hasPriorityBoarding = Boolean.parseBoolean(data[6]);
                String frequentFlyerNumber = data[7];
                Adult adult = new Adult(name, passportNumber, ticketNumber, age, hasPriorityBoarding, frequentFlyerNumber);
                passengers.add(adult);
            } else {
                String guardianName = data[5];
                Child child = new Child(name, passportNumber, ticketNumber, age, guardianName);
                passengers.add(child);
            }
        }
        reader.close();
    }

    private static Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equalsIgnoreCase(name)) {
                return passenger;
            }
        }
        return null;
    }

    
}
