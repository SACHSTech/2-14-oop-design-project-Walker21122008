import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Main class for the AirTravel Buddy application.
 * Provides a console-based interface for users to interact with airports, terminals, flights, and passengers.
 * Users can search for airports, view flights, manage bookings, and more.
 * @author Hasini Vijay Inbasri
 */
public class Main {

    // List of all airports loaded from the Airport database 
    private static ArrayList<Airport> ListOfAirports = new ArrayList<>();
    // List of all terminals loaded from the Airport database 
    private static ArrayList<Terminal> ListOfTerminals = new ArrayList<>();
    // List of all flights loaded from the Airport database 
    private static ArrayList<Flight> ListOfFlights = new ArrayList<>();
    //List of all passengers loaded from the Airport database
    private static ArrayList<Passenger> ListOfPassengers = new ArrayList<>();

    private static BufferedReader reader;

    /**
     * Entry point for the AirTravel Buddy application.
     * Loads data, prints welcome message, and starts the main menu loop.
     * @author Hasini Vijay Inbasri
     */
    public static void main(String[] args) throws IOException {
        loadUpTheAirportsTerminalsFlightsPassengers();
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! Welcome to AirTravel Buddy! I'm Helpy! Your personal travel buddy!");
        System.out.println("          __|__");
        System.out.println("   --@--@--(_)--@--@--");
        System.out.println("                  ");
        System.out.println("                  ");
        System.out.println("[____________________]");
        System.out.println(" \\       ----       /");
        System.out.println("  \\________________/");

        mainMenu();
    }

    /**
     * Displays the main menu and handles user navigation for airport selection or viewing.
     * @throws IOException if input reading fails
     * @author Hasini Vijay Inbasri
     */
    private static void mainMenu() throws IOException {
        System.out.println("Please choose your airport or choose to view all:");
        System.out.println("1| By Code");
        System.out.println("2| By Name");
        System.out.println("3| View all airports!");
        System.out.println("4| Exit");
        System.out.print("Enter your choice: ");

        String input = reader.readLine();
        Airport airport;

        switch (input) {
            case "1":
                // Search airport by code
                System.out.print("\nEnter airport code: ");
                String code = reader.readLine();
                airport = AirportDatabase.findAirportBySpecifiedDetail("Code", code);
                if (airport == null) {
                    System.out.println("Helpy says that the airport you entered was not found. Please try again!");
                } else {
                    airportHelpMenu(airport);
                }
                break;

            case "2":
                // Search airport by name
                System.out.print("\nEnter airport name: ");
                String name = reader.readLine();
                airport = AirportDatabase.findAirportBySpecifiedDetail("Name", name);
                if (airport == null) {
                    System.out.println("Helpy says that Airport not found. Please try again.");
                } else {
                    airportHelpMenu(airport);
                }
                break;

            case "3":
                // List all available airports
                System.out.println(" _____________________________________");
                System.out.println("\n List of Airports taken by Helpy:  ");
                System.out.println(" _____________________________________");
                for (Airport specifiedAirport : ListOfAirports) {
                    System.out.println(specifiedAirport.getAirportInfo());
                    System.out.println("--------------------------------------");
                }
                break;

            case "4":
                // Exit the program
                System.out.println("Thank you for using AirTravel Buddy! - Helpy");
                return;

            default:
                // Invalid input
                System.out.println("Uhh That was an invalid option. Helpy asks you to try again!");
                break;
        }
        mainMenu();
    }

    /**
     * Displays a menu for a specific airport, allowing the user to search for flights, view terminals, or list flights.
     * @param airport The airport selected by the user
     * @throws IOException if input reading fails
     * @author Hasini Vijay Inbasri
     */
    private static void airportHelpMenu(Airport airport) throws IOException {
        System.out.println("Hello Passenger! Your airport details are the follows: ");
        System.out.println(airport.getAirportInfo());
        System.out.println("\nHelpy is here to help you! Here is the Airport Menu:");
        System.out.println("1. Find Flight by Flight Number");
        System.out.println("2. List all terminals");
        System.out.println("3. List all flights");
        System.out.println("4. Go Back to Previous Menu");
        // Fun ASCII art for user engagement
        System.out.println("  (()__(()\r\n" +
                "  /       \\\r\n" +
                " ( /    \\  \\\r\n" +
                "  \\ o o    /\r\n" +
                "  (_()_)__/ \\\r\n" +
                " / _,==.____ \\\r\n" +
                "(   |--|      )\r\n" +
                "/\\_.|__|'-.__/\\\r\n" +
                "\\    .--'--,  /\r\n" +
                "  .  .--'--'/");

        System.out.print("Hey! Helpy here again! Please choose an option: ");
        String choice = reader.readLine();
        Flight flight;

        switch (choice) {
            case "1":
                // Find flight by flight number
                flight = AirportDatabase.findFlightByFlightNumber(airport);
                if (flight != null)
                    flightHelpMenu(flight);
                break;
            case "2":
                // List all terminals in the airport
                System.out.println(" _____________________________________");
                System.out.println("\n List of Terminals taken by Helpy:  ");
                System.out.println(" _____________________________________");
                for (Terminal terminal : airport.getTerminals()) {
                    System.out.println(terminal.getTerminalInfo() + ", " + terminal.checkTerminalCapacity());
                }
                break;
            case "3":
                // List all flights from all terminals
                int FlightcountValueIncrementer = 1;
                System.out.println(" ______________________________________________________");
                System.out.println("\n List of flights from all terminals taken by Helpy:  ");
                System.out.println(" ______________________________________________________");
                for (Terminal terminal : airport.getTerminals()) {
                    System.out.println("Hey Passenger! Here are the flights in Terminal: " + terminal.getTerminalNumber());
                    for (Flight flightNumber : terminal.getAllFlights()) {
                        System.out.println("Flight number " + FlightcountValueIncrementer);
                        System.out.println(flightNumber.getSummaryFlightInfo());
                        FlightcountValueIncrementer++;
                    }
                    System.out.println("\n\n");
                }
                break;
            case "4":
                // Go back to previous menu
                System.out.println("Okay, Helpy will return you to previous menu");
                return;
            default:
                // Invalid input
                System.out.println("Unfortunately, Helpy says that's an invalid option!");
        }
        airportHelpMenu(airport);
    }

    /**
     * Displays a menu for a specific flight, allowing the user to view details, find passengers, or go back.
     * @param flightAssigned The flight selected by the user
     * @throws IOException if input reading fails
     * @author Hasini Vijay Inbasri
     */
    private static void flightHelpMenu(Flight flightAssigned) throws IOException {
        System.out.println("\nFlight Help Options for flight number (" + flightAssigned.getFlightNumber() + "):");
        System.out.println("1. Show Flight Details");
        System.out.println("2. Find Passenger By Ticket Number");
        System.out.println("3. Go Back");
        System.out.print("Please choose an option: ");
        String choice = reader.readLine();

        switch (choice) {
            case "1":
                // Show flight details
                System.out.println(flightAssigned.getFlightInfo());
                break;

            case "2":
                // Find passenger by ticket number
                System.out.println("Dear Passenger, Please enter your ticket number: ");
                String ticketNumber = reader.readLine();
                Passenger passenger = flightAssigned.findPassengerByTicketNumber(ticketNumber);
                if (passenger != null) {
                    passengerHelpMenu(passenger, flightAssigned);
                } else {
                    System.out.println("Helpy says that the passenger name was not found; Please try again :(");
                }
                break;

            case "3":
                // Go back to previous menu
                System.out.println("Returning to previous menu");
                return;
            default:
                // Invalid input
                System.out.println("Invalid option. Please try again.");
        }
        flightHelpMenu(flightAssigned);
    }

    /**
     * Displays a menu for a specific passenger, allowing booking management, check-in, info update, etc.
     * @param passenger The passenger selected by the user
     * @param flight The flight associated with the passenger
     * @throws IOException if input reading fails
     * @author Hasini Vijay Inbasri
     */
    public static void passengerHelpMenu(Passenger passenger, Flight flight) throws IOException {
        System.out.println("\nPassenger Help Options for passenger name (" + passenger.getName() + " - " + passenger.getAge() + "):");

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
                // Cancel booking
                flight.removePassenger(passenger.getTicketNumber());
                return;

            case "2":
                // Check in the passenger
                System.out.println(passenger.checkIn());
                break;

            case "3":
                // Show flight status
                System.out.println(flight.getFlightStatus());
                break;

            case "4":
                // Update passenger contact info
                System.out.println("Dear Passenger, Helpy asks you to enter your new contact number:");
                long contactNumber = Long.parseLong(reader.readLine());

                passenger.updateContactNumber(contactNumber);
                break;

            case "5":
                // Request special assistance
                System.out.println("Dear Passenger, Please provide your special request service type:");
                String serviceType = reader.readLine();
                passenger.requestSpecialAssistance(serviceType);
                break;

            case "6":
                // Show passenger info
                System.out.println(passenger.getPassengerInfo());
                break;

            case "7":
                // Go back to previous menu
                System.out.println("Returning to previous menu");
                return;

            default:
                // Invalid input
                System.out.println("Invalid option. Please try again.");
                break;
        }
        passengerHelpMenu(passenger, flight);
    }

    /**
     * Loads all airports, terminals, flights, and passengers from their respective CSV files.
     * @throws IOException if file reading fails
     * @author Hasini Vijay Inbasri
     */
    private static void loadUpTheAirportsTerminalsFlightsPassengers() throws IOException {
        ListOfAirports = AirportDatabase.loadAirportsFromCSV("src/Airport.csv");
        ListOfTerminals = AirportDatabase.loadTerminalsFromCSV("src/Terminal.csv");
        ListOfFlights = AirportDatabase.loadFlightsFromCSV("src/Flight.csv");
        ListOfPassengers = AirportDatabase.loadPassengersFromCSV("src/Passengers.csv");
    }
}
