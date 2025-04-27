
public class Passenger {
    private String passportNumber;
    private String ticketNumber;
    private Flight assignedFlight;
    private int age;
    private String name;
    private boolean checkInStatus;

    public Passenger(String name, String passportNumber, String ticketNumber, int age) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.ticketNumber = ticketNumber;
        checkInStatus = false;
        this.age = age;
    }

    public String getTicketNumber(){
        return ticketNumber;
    }
    
    public int getAge(){
        return age;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public Flight getAssignedFlight() {
        return assignedFlight;
    }


    public String getName(){
        return name;
    }

    public void cancelBooking() {
        assignedFlight = null;
        System.out.println("Booking cancelled.");
    }


    public String checkIn() {
        if (assignedFlight != null) {
            String flightNumber = assignedFlight.getFlightNumber();
            checkInStatus = true;
            return "Checked in for flight " + flightNumber;
        } else {
            return "No flight to check in. Please book a flight first.";
        }
    }
    

    public void requestSpecialAssistance(String serviceType) {
        System.out.println("Special assistance requested: " + serviceType);
        System.out.println("An assistant has been sent your way!");
    }
}

