package PhonePackage;

public interface Phone {

    void callTo(Phone phone);
    void pickUpTheCall(Phone phone);
    void hangUpTheCall(Phone phone);

    void incomingCall(Phone phone);
    void callIgnore(Phone phone);
    void endCall();
    void sendMessage();
    void receiveMessage(String message);
    void setPairedPhone(Phone phone);

    Phone getPairedPhone();

    String getPhoneNumber();

}
