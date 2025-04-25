import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Airport> airports = new ArrayList<>();
    private static List<Passengers> passengers = new ArrayList<>();
    private static List<Gate> gates = new ArrayList<>();
    private static List<Terminal> terminals = new ArrayList<>();
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    

    }

    private static void setUpTheAirports() throws IOException{

        loadAirportsFromCSV("Passengers.csv");
        loadGatesFromCSV("Gates.csv");
        loadPassengersFromCSV("Passengers.csv");

    }

    private static void loadAirportsFromCSV(String csvFile) throws IOException {

    }

    private static void loadGatesFromCSV(String csvFile) throws IOException {
        
    }

    private static void loadPassengersFromCSV(String csvFile) throws IOException {
    
    }

}
