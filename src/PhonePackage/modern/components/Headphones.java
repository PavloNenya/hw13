package PhonePackage.modern.components;

public class Headphones {
    private final String type;
    private final int maximumFrequency;
    private final int minimumFrequency;
    private final String connectorType;

    public Headphones(String type, int maximumFrequency, int minimumFrequency, String connectorType) {
        this.type = type;
        this.maximumFrequency = maximumFrequency;
        this.minimumFrequency = minimumFrequency;
        this.connectorType = connectorType;
    }

    public String getType() {
        return type;
    }

    public int getMaximumFrequency() {
        return maximumFrequency;
    }

    public int getMinimumFrequency() {
        return minimumFrequency;
    }

    public String getConnectorType() {
        return connectorType;
    }
}
