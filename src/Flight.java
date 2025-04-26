
public class Flight {
    private String flightNumber;
    private String airline;
    private String destination;
    private String origin;
    private String departureTime; 
    private String status;

    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String status) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.status = status;
    }

    
    public String getFlightStatus() {
        return "Flight " + flightNumber + " is " + status;
    }

    public String getAirline(){
        return airline;
    }

    public String getDestination(){
        return destination;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDepartureTime(){
        return departureTime;
    }

    public void delayFlight(String newTime) {
        departureTime = newTime;
        status = "Delayed";
    }

    public void updateStatus(String newStatus) {
        status = newStatus;
    }

    public String getFlightDetails() {
        return "Flight Number: " + flightNumber + ", Airline: " + airline +
               ", Destination: " + destination + ", Departure Time: " + departureTime +
               ", Status: " + status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String timeToReachTerminal(){
        return "Make sure to return atleast 2 hours before your flight's departure time: " + departureTime;
    }
}

