import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Airport> airports = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setUpTheAirports();
        System.out.println("Hello Passenger! Welcome to AirTravel Buddy! Please choose the airport name:");
        //for (Airport airport : airports) {
        //    System.out.println(airport.getAirportInfo());
        //}
    }

    private static void setUpTheAirports() throws IOException {
        loadAirportsFromCSV("src/Airport.csv");
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
            String[] data = line.split(",");
            String airportName = data[0];
            String location = data[1];
            String code = data[2];

            boolean exists = false;
            for (Airport airport : airports) {
                if (airport.getAirportName().equals(airportName)) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                Airport airport = new Airport(airportName, location, code);
                airports.add(airport);
            }
        }
        reader.close();
    }
}
