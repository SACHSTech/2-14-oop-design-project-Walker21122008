import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Airport> airports = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Terminal> terminals = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        setUpTheAirports();
        System.out.println("Hello Passenger! Welcome to AirTravel Buddy! Please choose the airport name.");
        for(Airport airport:airports){
        }
    

    }

    private static void setUpTheAirports() throws IOException{

        loadAirportsFromCSV("Passengers.csv");
        loadGatesFromCSV("Gates.csv");
        loadPassengersFromCSV("Passengers.csv");

    }

    private static void loadAirportsFromCSV(String csvFile) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                String airportName = data[0];
                String location = data[13];
                String amenities = data[14];

                if (!airports.contains(airportName)) {
                    Airport airport = new Airport(airportName, location, amenities);
                    airports.add(airport);
                }
            }
    }

    private static void loadGatesFromCSV(String csvFile) throws IOException {
        
    }

    private static void loadPassengersFromCSV(String csvFile) throws IOException {
    
    }

}
