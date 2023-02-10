package PhonePackage.modern.components;

public class BatteryCharger {
    private final int voltage;
    private final double lengthOfWire;
    private final String connectorType;

    public BatteryCharger(int voltage, double lengthOfWire, String connectorType) {
        this.voltage = voltage;
        this.lengthOfWire = lengthOfWire;
        this.connectorType = connectorType;
    }

    public int getVoltage() {
        return voltage;
    }

    public double getLengthOfWire() {
        return lengthOfWire;
    }

    public String getConnectorType() {
        return connectorType;
    }
}
