public class Child extends Passenger {
    private String guardianName;
    private int age;
    private boolean requiresMealAssistance;

    public Child(String passportNumber, String ticketNumber, String guardianName, boolean requiresMealAssistance) {
        super(passportNumber, ticketNumber);
        this.guardianName = guardianName;
        this.requiresMealAssistance = requiresMealAssistance;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public int getAge(){
        return age;
    }

    public String requiresSpecialToys(){
        if(age < 6){
            return "Yes. The items will be provided since the child is under 6";
        } else {
            return "No. Your child is over the age limit so he/she would not be provided the things.";
        }
    }

    public boolean isMealAssistanceRequired() {
        return requiresMealAssistance;
    }

    public void requestActivityKit() {
        System.out.println("Activity kit requested for the child.");
    }
}
