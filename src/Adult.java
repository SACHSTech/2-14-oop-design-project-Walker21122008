public class Adult extends Passenger {
    private boolean hasPriorityBoarding;
    private String frequentFlyerNumber;

    public Adult(String passportNumber, String ticketNumber, boolean hasPriorityBoarding, String frequentFlyerNumber) {
        super(passportNumber, ticketNumber);
        this.hasPriorityBoarding = hasPriorityBoarding;
        this.frequentFlyerNumber = frequentFlyerNumber;
    }

    public boolean isPriorityBoarding() {
        return hasPriorityBoarding;
    }

    public String getFrequentFlyerNumber() {
        return frequentFlyerNumber;
    }

    public void requestMeal() {
        System.out.println("Meal access requested.");
    }

}
