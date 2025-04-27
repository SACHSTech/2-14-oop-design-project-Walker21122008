public class Adult extends Passenger {
    private boolean hasPriorityBoarding;
    private String frequentFlyerNumber;

    public Adult(String passportNumber, String ticketNumber, boolean hasPriorityBoarding, String frequentFlyerNumber, int age) {
        super(passportNumber, ticketNumber);
        this.hasPriorityBoarding = hasPriorityBoarding;
        this.frequentFlyerNumber = frequentFlyerNumber;
        this.age = age;
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

    public void informHoursUntilLanding(Flight flight) {
        int hours = flight.hoursUntilLanding();
        System.out.println("Flight " + flight.getFlightNumber() + " will land in " + hours + " hours.");
    }


}
