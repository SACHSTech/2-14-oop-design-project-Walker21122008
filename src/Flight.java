
public class Flight {
    private String flightNumber;
    private String airline;
    private String destination;
    private String origin;
    private String departureTime;
    private String arrivalTime; 
    private String status;

    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String arrivalTime, String status) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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

    public String getArrivalTime(){
        return arrivalTime;
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

    public int hoursUntilLanding() {
        String[] depParts = departureTime.split(":");
        String[] arrParts = arrivalTime.split(":");
        
        int depHour = Integer.parseInt(depParts[0]);
        int depMinute = Integer.parseInt(depParts[1]);
        int arrHour = Integer.parseInt(arrParts[0]);
        int arrMinute = Integer.parseInt(arrParts[1]);

        int depTotalMinutes = depHour * 60 + depMinute;
        int arrTotalMinutes = arrHour * 60 + arrMinute;

        int differenceMinutes = arrTotalMinutes - depTotalMinutes;
        return differenceMinutes / 60;
    }


    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String timeToReachTerminal(){
        return "Make sure to return atleast 2 hours before your flight's departure time: " + departureTime;
    }
}

