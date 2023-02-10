package PhonePackage;

import java.util.*;

public class PhoneWithAnsweringMachine extends PhoneImpl implements AnsweringMachine {


    private final Map<String, List<String>> answeringMachineHistory = new HashMap<>();

    private boolean isAnsweringMachine;

    public PhoneWithAnsweringMachine(String phoneNumber) {
        super(phoneNumber);
    }

    @Override
    public void answeringMachine(Phone phone) {
        setPairedPhone(phone);
        phone.setPairedPhone(this);
        isAnsweringMachine = true;
        System.out.println(("Leave your message on the answering machine"));
        answeringMachineHistory.putIfAbsent(phone.getPhoneNumber(), new LinkedList<>());
        phone.sendMessage();
        isAnsweringMachine = false;
        endCall();
    }

    @Override
    public void receiveMessage(String message) {

        if(isAnsweringMachine) {
            answeringMachineHistory.get(getPairedPhone().getPhoneNumber()).add(message);
        }
        else {
            System.out.println("Message received");
            callProcess();
        }
    }

    @Override
    public void incomingCall(Phone phone) {
        System.out.println(getPhoneNumber() + ", " + phone.getPhoneNumber() + " calling to you");
        System.out.println("""
                1 - Pick up the phone
                2 - hang up
                3 - answering machine""");
        IncomingCallOperation choice = callChoice();
        if(choice == null) {
            callIgnore(phone);
            return;
        }
        switch (choice) {
            case PICK_UP -> {
                pickUpTheCall(phone);
            }

            case HANG_UP -> {
                hangUpTheCall(phone);
            }

            case CALL_IGNORE -> {
                callIgnore(phone);
            }

            case ANSWERING_MACHINE -> {
                answeringMachine(phone);
            }

            default -> {

            }
        }
    }

    private IncomingCallOperation callChoice() {
        long timeBeforeChoice = System.currentTimeMillis();
        int choice = scanner.nextInt();
        if(System.currentTimeMillis()-timeBeforeChoice >= 30*1000) {
            System.out.println("You missed the call");
            return IncomingCallOperation.CALL_IGNORE;
        }
        switch (choice) {
            case 1 -> {
                return IncomingCallOperation.PICK_UP;
            }
            case 2 -> {
                return IncomingCallOperation.HANG_UP;
            }

            case 3 -> {
                return IncomingCallOperation.ANSWERING_MACHINE;
            }

            default -> {
                System.out.println("Error");
                return null;
            }
        }
    }

    public Map<String, List<String>> getAnsweringMachineHistory() {
        return answeringMachineHistory;
    }

}
