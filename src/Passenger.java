import java.util.ArrayList;

public class Passenger {
    private String passportNumber;
    private String ticketNumber;
    private Flight assignedFlight;

    public Passenger(String passportNumber, String ticketNumber) {
        this.passportNumber = passportNumber;
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber(){
        return ticketNumber;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public void cancelBooking() {
        assignedFlight = null;
        System.out.println("Booking cancelled.");
    }


    public String checkIn() {
        if (assignedFlight != null) {
            String flightNumber = assignedFlight.getFlightNumber();
            return "Checked in for flight " + flightNumber;
        } else {
            return "No flight to check in.";
        }
    }

    public void bookFlight(ArrayList<Flight> flights, String flightNumber) {
        boolean flightFound = false;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                    this.assignedFlight = flight;
                    System.out.println("Flight " + flightNumber + " booked successfully!");
                    flightFound = true;
                    break;
            }
        }
        if (!flightFound) {
            System.out.println("Flight " + flightNumber + " does not exist.");
        }
    }

    

    public void requestSpecialAssistance(String serviceType) {
        System.out.println("Special assistance requested: " + serviceType);
        System.out.println("An assistant has been sent your way!");
    }
}

