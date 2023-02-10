package PhonePackage.modern.components;

public class Processor {
    private final int numberOfCores;
    private final double frequency;

    public Processor(int numberOfCores, double frequency) {
        this.numberOfCores = numberOfCores;
        this.frequency = frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public double getFrequency() {
        return frequency;
    }
}
