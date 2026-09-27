package fitness;

public class EmailChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("EMAIL to " + recipient + ": " + message);
    }
}