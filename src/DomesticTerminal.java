public class DomesticTerminal extends Terminal {
    private String domesticCarrier;

    public DomesticTerminal(String terminalNumber, int capacity, String domesticCarrier) {
        super(terminalNumber, capacity);
        this.domesticCarrier = domesticCarrier;
    }

    public String getDomesticCarrier() {
        return domesticCarrier;
    }

    public void setDomesticCarrier(String domesticCarrier) {
        this.domesticCarrier = domesticCarrier;
    }

    public String displayDomesticCarrierInfo() {
        return "Domestic Terminal operates carrier: " + domesticCarrier;
    }
}
