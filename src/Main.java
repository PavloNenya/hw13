import PhonePackage.*;
import PhonePackage.modern.SensorPhone;
import PhonePackage.modern.components.*;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Headphones headphones = new Headphones("Earbuds", 15000, 15, "miniJack");
        Headphones headphones1 = new Headphones("Earbuds", 20000, 20, "USB");

        BatteryCharger batteryCharger = new BatteryCharger(5, 2, "Type-C");
        BatteryCharger batteryCharger1 = new BatteryCharger(5, 1.5, "mini-USB");

        Camera camera = new Camera(50, new LinkedList<>(Arrays.asList("Panoramic view", "Video", "Macro")), 4000);

        OperativeMemory operativeMemory = new OperativeMemory(8000);

        Processor processor = new Processor(4, 2.1);

        SensorPhone sensorPhone = new SensorPhone("+380998887766",
                "Android",
                operativeMemory,
                256,
                processor,
                camera);

        sensorPhone.setHeadphones(headphones);
        sensorPhone.setBatteryCharger(batteryCharger1);

        PhoneWithAnsweringMachine myPhone = new PhoneWithAnsweringMachine("+380971231212");
        SimplePhone friendsHomePhone = new SimplePhone("+380993213232");

        friendsHomePhone.callTo(myPhone);

        myPhone.callTo(friendsHomePhone);

        sensorPhone.callTo(myPhone);

        System.out.println("Answering machine on my phone: ");
        System.out.println(myPhone.getAnsweringMachineHistory());
    }
}