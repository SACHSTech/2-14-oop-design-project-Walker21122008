/**
 * Represents a Domestic Terminal in an airport, extending the Terminal class.
 * Includes specific details about the domestic carrier it operates.
 * @author Hasini Vijay Inbasri
 */
public class DomesticTerminal extends Terminal {
    private String domesticCarrier; // Name of the domestic carrier operating in the terminal

    /**
     * Creates a new Domestic Terminal instance.
     * @param terminalNumber The terminal number.
     * @param capacity The passenger capacity of the terminal.
     * @param airportCode The code of the airport the terminal belongs to.
     * @param type The type of terminal (e.g., domestic or international).
     * @param domesticCarrier The domestic carrier operating in the terminal.
     */
    public DomesticTerminal(String terminalNumber, int capacity, String airportCode, String type, String domesticCarrier) {
        super(terminalNumber, capacity, airportCode, type);
        this.domesticCarrier = domesticCarrier;
    }

    /**
     * Gets the name of the domestic carrier operating in the terminal.
     * @return The name of the domestic carrier.
     */
    public String getDomesticCarrier() {
        return domesticCarrier;
    }

    /**
     * Sets the name of the domestic carrier operating in the terminal.
     * @param domesticCarrier The name of the domestic carrier to set.
     */
    public void setDomesticCarrier(String domesticCarrier) {
        this.domesticCarrier = domesticCarrier;
    }

    /**
     * Displays information about the domestic carrier operating in the terminal.
     * @return A string containing carrier information.
     */
    public String displayDomesticCarrierInfo() {
        return "Terminal operates carrier: " + domesticCarrier;
    }

    /**
     * Retrieves the terminal's information along with domestic carrier details.
     * @return A string containing the terminal's information and carrier details.
     */
    public String getTerminalInfo() {
        return super.getTerminalInfo() + ", " + displayDomesticCarrierInfo();
    }
}
