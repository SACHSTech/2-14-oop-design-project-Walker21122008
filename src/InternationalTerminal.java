public class InternationalTerminal extends Terminal {
    private boolean customsAvailable;

    public InternationalTerminal(String terminalNumber, int capacity, String airportCode, String type, boolean customsAvailable) {
        super(terminalNumber, capacity, airportCode, type);
        this.customsAvailable = customsAvailable;
    }

    public boolean isCustomsAvailable() {
        return customsAvailable;
    }

    public void setCustomsAvailable(boolean customsAvailable) {
        this.customsAvailable = customsAvailable;
    }

    public String displayCustomsInfo() {
        if (customsAvailable) {
            return "International Terminal Customs Available: Yes";
        } else {
            return "International Terminal Customs Available: No";
        }
    }
}
