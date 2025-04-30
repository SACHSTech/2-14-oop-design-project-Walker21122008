import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private String airline;
    private String destination;
    private String origin;
    private String departureTime;
    private String arrivalTime; 
    private String status;
    private String terminalNumber;
    private String airportCode;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber, String airline, String origin, String destination, String departureTime, String arrivalTime, String status, String terminalNumber, String airportCode) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.terminalNumber = terminalNumber;
        this.airportCode = airportCode;
        this.passengers = new ArrayList<>();
    }

    
    public String getFlightStatus() {
        return "Flight " + flightNumber + " status is " + status;
    }

    public String getAirline(){
        return airline;
    }

    public String getDestination(){
        return destination;
    }

    public String getAirportCode(){
        return airportCode;
    }

    public String getTerminalNumber(){
        return terminalNumber;
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public double getFlightDurationInHours() {
        String[] depParts = departureTime.split(":");
        String[] arrParts = arrivalTime.split(":");
        
        int depHour = Integer.parseInt(depParts[0]);
        int depMinute = Integer.parseInt(depParts[1]);
        int arrHour = Integer.parseInt(arrParts[0]);
        int arrMinute = Integer.parseInt(arrParts[1]);

        int depTotalMinutes = depHour * 60 + depMinute;
        int arrTotalMinutes = arrHour * 60 + arrMinute;

        int differenceMinutes = arrTotalMinutes - depTotalMinutes;
        return differenceMinutes / 60.0;
    }


    public String timeToReachTerminal(){
        return "Make sure to return atleast 2 hours before your flight's departure time: " + departureTime;
    }

    public String getFlightInfo(){
        String flightInfo = "";
        flightInfo += "Your flight details:  ";
        flightInfo += "\nFlight Number - " + getFlightNumber();
        flightInfo += "\nOrigin - " + getOrigin();
        flightInfo += "\nDestination- " + getDestination();
        flightInfo += "\nDeparture Time: " + getDepartureTime();
        flightInfo += "\nArrival Time: " + getArrivalTime();
        flightInfo += "\nFlight Duration in Hours: " + getFlightDurationInHours();
        flightInfo += "\n"+ timeToReachTerminal();

        return flightInfo;
    }

    public Passenger findPassengerByName(String passengerName) {
        for (Passenger passenger : passengers) { 
            if (passenger.getName().equalsIgnoreCase(passengerName)) { 
                return passenger; 
            }
        }
        return null; 
    }

    public Passenger findPassengerByTicketNumber(String ticketNumber) {
        for (Passenger passenger : passengers) { 
            if (passenger.getTicketNumber().equalsIgnoreCase(ticketNumber)) { 
                return passenger; 
            }
        }
        return null; 
    }

    public boolean removePassenger(String ticketNumber) {
        Passenger passenger = findPassengerByTicketNumber(ticketNumber);
        
        if (passenger != null && passenger.cancelBooking() == true) {
            passengers.remove(passenger);
            return true;
        }

        return false;
     }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }


    
}

