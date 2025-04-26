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

    public String howLongDoesCheckInTake(){
        return "Check in takes atlest a minimum of 30 hours up to 2 hours. Make sure you come as early as possible!";
    }
    

    public void requestSpecialAssistance(String serviceType) {
        System.out.println("Special assistance requested: " + serviceType);
        System.out.println("An assistant has been sent your way!");
    }
}

