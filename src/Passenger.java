
public class Passenger {
    private String name;
    private int age;
    private String passportNumber;
    private String ticketNumber;
    private String assignedFlightNumber;
    private boolean checkInStatus;
    private String contactNumber;

    public Passenger(String name, String passportNumber, String assignedFlightNumber, String ticketNumber, int age) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.ticketNumber = ticketNumber;
        this.assignedFlightNumber = assignedFlightNumber;
        this.age = age;
        this.checkInStatus = false;
        this.contactNumber = null;
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

    public String getAssignedFlightNumber() {
        return assignedFlightNumber;
    }


    public String getName(){
        return name;
    }

    public boolean getCheckInStatus() {
        return checkInStatus;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public boolean cancelBooking(){

        if (assignedFlightNumber != null) {
            if (checkInStatus == false){
                System.out.println("Booking cancelled.");
                assignedFlightNumber = null;
                return true;
            }

        }
        System.out.println("You do not have an assigned flight or you have already checked in");
        return false;

    }




    public String checkIn() {
        if (assignedFlightNumber != null && !assignedFlightNumber.isEmpty()) {
            if  (!checkInStatus) {
                checkInStatus = true;
                return "Checked in for flight " + assignedFlightNumber;
            } else {
                return "You have already checked in.";
            }

        } else {
            return "No flight to check in. Please book a flight first.";
        }
    }
    
    public void updateContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    

    public void requestSpecialAssistance(String serviceType) {
        System.out.println("Special assistance requested: " + serviceType);
        System.out.println("An assistant has been sent your way!");
    }

    public String getPassengerInfo() {
        String passengerInfo = "";
        passengerInfo += "Name: " + getName();
        passengerInfo += "\nPassport Number: " + getPassportNumber();
        passengerInfo += "\nFlight Number: " + getAssignedFlightNumber();
        passengerInfo += "\nTicket Number: " + getTicketNumber();
        passengerInfo += "\nCheckin Status: " + getCheckInStatus();
        passengerInfo += "\nContact Number: " + getContactNumber();
        return passengerInfo;
    }
}

