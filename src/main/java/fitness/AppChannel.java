package fitness;

public class AppChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("APP notification to " + recipient + ": " + message);
    }
}