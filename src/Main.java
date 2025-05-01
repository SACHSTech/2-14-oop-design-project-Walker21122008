import java.io.BufferedReader;
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
        System.out.println("Hello! Welcome to AirTravel Buddy! I'm helpy! Your personal travel buddy!");
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
        System.out.println("1| By Code");
        System.out.println("2| By Name");
        System.out.println("3| View all airports!");
        System.out.println("4| Exit");
        System.out.print("Enter your choice: ");

        String input = reader.readLine();

        Airport airport;

        switch (input) {
            case "1":
                System.out.print("\nEnter airport code: ");
                String code = reader.readLine();
                airport = csvLoader.findAirportByDetail("Code", code);
                if (airport == null) {
                    System.out.println("Helpy says that the airport you entered was not found. Please try again!");
                } else {
                    airportHelpMenu(airport);
                }
                
                break;

            case "2":
                System.out.print("\nEnter airport name: ");
                String name = reader.readLine();
                airport = csvLoader.findAirportByDetail("Name", name);
                if (airport == null) {
                    System.out.println("Helpy says that Airport not found. Please try again.");
                } else {
                    airportHelpMenu(airport);
                }
                break;

            case "3":
                System.out.println(" _____________________________________");
                System.out.println("\n List of Airports taken by Helpy:  ");
                System.out.println(" _____________________________________");
                for (Airport a : airports) {
                    System.out.println(a.getAirportInfo());
                    System.out.println("--------------------------------------");
                }
                break;

            case "4":
                System.out.println("Thank you for using AirTravel Buddy! - Helpy");
                return;

            default:
                System.out.println("Uhh That was an invalid option. Helpy asks you to try again!");
                break;
        }
        mainMenu();
    }

    private static void airportHelpMenu(Airport airport) throws IOException {
        System.out.println("Hello Passenger! Your airport details are the follows: ");
        System.out.println(airport.getAirportInfo());
            System.out.println("\nHelpy is here to help you! Here is the Airport Menu:");
            System.out.println("1. Find Flight by Flight Number");
            System.out.println("2. List all terminals");
            System.out.println("3. List all flights");
            System.out.println("4. Go Back to Previous Menu");
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
                    flight = findFlightByFlightNumber(airport);
                    if (flight!= null) flightHelpMenu(flight);
                    break;
                case "2":
                    System.out.println(" _____________________________________");
                    System.out.println("\n List of Terminals taken by Helpy:  ");
                    System.out.println(" _____________________________________");
                    for (Terminal terminal : airport.getTerminals()) {
                        System.out.println(terminal.getTerminalInfo() + ", " + terminal.checkTerminalCapacity());
                    }                 
                    break;
                case "3":
                    int count = 1;
                    System.out.println(" ______________________________________________________");
                    System.out.println("\n List of flights from all terminals taken by Helpy:  ");
                    System.out.println(" ______________________________________________________");
                    for (Terminal terminal : airport.getTerminals()) {
                        System.out.println("Hey Passenger! Here are the flights in Terminal: " + terminal.getTerminalNumber());
                        for (Flight flightNumber: terminal.getAllFlights()) {
                            System.out.println("Flight number " + count);
                            System.out.println(flightNumber.getFlightInfoInOneLine());
                            count ++;
                        }
                        System.out.println("\n\n");
                    }
                    break;
                case "4":
                    System.out.println("Okay, Helpy will return you to previous menu");
                    return;
                default:
                    System.out.println("Unfortunately, Helpy says that's an invalid option!");
            }
            airportHelpMenu(airport);
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
                System.out.println(passenger.checkIn());
                break;

            case "3":
                System.out.println(flight.getFlightStatus());
                break;
            
            case "4":
                System.out.println("Dear Passenger, Helpy asks you to enter your new contact number:");
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
        airports = csvLoader.loadAirportsFromCSV("src/Airport.csv");
        terminals = csvLoader.loadTerminalsFromCSV("src/Terminal.csv");
        flights = csvLoader.loadFlightsFromCSV("src/Flight.csv");
        passengers = csvLoader.loadPassengersFromCSV("src/Passengers.csv");
    }


}
