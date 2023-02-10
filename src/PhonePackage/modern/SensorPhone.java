package PhonePackage.modern;

import PhonePackage.PhoneWithAnsweringMachine;
import PhonePackage.modern.components.*;

public class SensorPhone extends PhoneWithAnsweringMachine implements Sensor {
    private int batteryCharge;
    private final String operatingSystem;
    private final OperativeMemory operativeMemory;
    private final int memoryCapacity;
    private BatteryCharger batteryCharger;
    private Headphones headphones;
    private final Processor processor;
    private final Camera camera;

    public SensorPhone(String phoneNumber,
                       String operatingSystem,
                       OperativeMemory operativeMemory,
                       int memoryCapacity,
                       Processor processor,
                       Camera camera) {
        super(phoneNumber);
        this.operatingSystem = operatingSystem;
        this.operativeMemory = operativeMemory;
        this.memoryCapacity = memoryCapacity;
        this.processor = processor;
        this.camera = camera;
        batteryCharge = 100;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public OperativeMemory getOperativeMemory() {
        return operativeMemory;
    }

    public BatteryCharger getBatteryCharger() {
        return batteryCharger;
    }

    public void setBatteryCharger(BatteryCharger batteryCharger) {
        this.batteryCharger = batteryCharger;
    }

    public Headphones getHeadphones() {
        return headphones;
    }

    public void setHeadphones(Headphones headphones) {
        this.headphones = headphones;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Camera getCamera() {
        return camera;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }
}
