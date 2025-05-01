/**
 * Represents an International Terminal in an airport, extending the Terminal class.
 * Includes specific details about the availability of customs services.
 * @author Hasini Vijay Inbasri
 */
public class InternationalTerminal extends Terminal {
    private boolean customsAvailable; // Indicates whether customs services are available in the terminal

    /**
     * Creates a new International Terminal instance.
     * @param terminalNumber The terminal number.
     * @param capacity The passenger capacity of the terminal.
     * @param airportCode The code of the airport the terminal belongs to.
     * @param type The type of terminal (e.g., domestic or international).
     * @param customsAvailable True if customs services are available, false otherwise.
     */
    public InternationalTerminal(String terminalNumber, int capacity, String airportCode, String type, boolean customsAvailable) {
        super(terminalNumber, capacity, airportCode, type);
        this.customsAvailable = customsAvailable;
    }

    /**
     * Checks if customs services are available in the terminal.
     * @return True if customs services are available, false otherwise.
     * @author Hasini Vijay Inbasri
     */
    public boolean isCustomsAvailable() {
        return customsAvailable;
    }

    /**
     * Sets the availability of customs services in the terminal.
     * @param customsAvailable True to enable customs services, false to disable them.
     * @author Hasini Vijay Inbasri
     */
    public void setCustomsAvailable(boolean customsAvailable) {
        this.customsAvailable = customsAvailable;
    }

    /**
     * Provides information about the availability of customs services in the terminal.
     * @return A string indicating whether customs services are available.
     * @author Hasini Vijay Inbasri
     */
    public String displayCustomsInfo() {
        if (customsAvailable) {
            return "Customs Available: Yes";
        } else {
            return "Customs Available: No";
        }
    }

    /**
     * Retrieves the terminal's information along with customs service details.
     * @return A string containing terminal information and customs service availability.
     * @author Hasini Vijay Inbasri
     */
    public String getTerminalInfo() {
        return super.getTerminalInfo() + ", " + displayCustomsInfo();
    }
}
