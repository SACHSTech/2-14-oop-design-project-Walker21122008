public class Child extends Passenger {
    private String guardianName;

    public Child(String name, String passportNumber, String ticketNumber, String assignedFlight, int age, String guardianName) {
        super(name, passportNumber, assignedFlight, ticketNumber, age);
        this.guardianName = guardianName;
    }

    public String getGuardianName() {
        return guardianName;
    }


    public String requiresSpecialToys(){
        if(getAge() < 6){
            return "Yes. The items will be provided since the child is under 6";
        } else {
            return "No. Your child is over the age limit so he/she would not be provided the things.";
        }
    }


    public void requestActivityKit() {
        System.out.println("Activity kit requested for the child.");
    }

    public String getPassengerInfo() {
        String passengerInfo = "";
        passengerInfo += super.getPassengerInfo();
        passengerInfo += "\nGuardian Name: " + getGuardianName();
        
        return passengerInfo;
    }
}
