public class Adult extends Passenger {
    private boolean hasPriorityBoarding;
    private String frequentFlyerNumber;

    public Adult(String name, String passportNumber, String ticketNumber, int age, boolean hasPriorityBoarding, String frequentFlyerNumber) {
        super(name, passportNumber, ticketNumber, age);
        this.hasPriorityBoarding = hasPriorityBoarding;
        this.frequentFlyerNumber = frequentFlyerNumber;
    }

    public boolean isPriorityBoarding() {
        return hasPriorityBoarding;
    }


    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    public String getElderlySeat(){
        if (getAge() >= 60){
            return "Yes, you will be getting the elderly seat";
        } else{
            return "No, you will not be getting the elderly seat";
        }
    }


    


}
