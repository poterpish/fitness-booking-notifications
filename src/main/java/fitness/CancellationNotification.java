package fitness;

public class CancellationNotification extends BookingNotification {

    public CancellationNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notify(String recipient, String className) {
        String message = "Your booking for " + className + " is cancelled.";
        channel.send(recipient, message);
    }
}