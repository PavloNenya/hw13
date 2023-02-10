package PhonePackage;

import java.util.Scanner;

public abstract class PhoneImpl implements Phone {
    Scanner scanner = new Scanner(System.in);
    private final String phoneNumber;

    private Phone pairedPhone;

    public PhoneImpl(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void callIgnore(Phone phone) {
        phone.endCall();
    }


    @Override
    public void sendMessage() {
        String message = scanner.nextLine();
        pairedPhone.receiveMessage(message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Message received");
        callProcess();
    }

    @Override
    public void pickUpTheCall(Phone phone) {
        setPairedPhone(phone);
        phone.setPairedPhone(this);
        callProcess();
    }

    protected void callProcess(){
        System.out.println("""
                1 - Send message
                2 - End call""");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                scanner.next();
                sendMessage();
            }
            case 2 -> endCall();
            default -> {
                System.out.println("Unknown command, try again");
                callProcess();
            }
        }
    }

    @Override
    public void callTo(Phone phone) {
        phone.incomingCall(this);
    }

    @Override
    public void hangUpTheCall(Phone phone) {
        phone.endCall();
    }

    @Override
    public void endCall() {
        if(pairedPhone != null) {
            pairedPhone.setPairedPhone(null);
            setPairedPhone(null);
        }
    }

    @Override
    public void incomingCall(Phone phone) {
        System.out.println(getPhoneNumber() + ", " + phone.getPhoneNumber() + " calling to you");
        System.out.println("""
                1 - Pick up the phone
                2 - hang up""");
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

            default -> {

            }
        }
    }

    // making choice what to do with call, if user doesn't choose within 30 seconds, call ignored
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

            default -> {
                System.out.println("Error");
                return null;
            }
        }
    }

    @Override
    public Phone getPairedPhone() {
        return pairedPhone;
    }

    @Override
    public void setPairedPhone(Phone pairedPhone) {
        this.pairedPhone = pairedPhone;
    }
}
