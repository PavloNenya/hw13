package PhonePackage.modern;

import PhonePackage.modern.components.OperativeMemory;

public interface Sensor {
    int getMemoryCapacity();
    OperativeMemory getOperativeMemory();
    String getOperatingSystem();

}
