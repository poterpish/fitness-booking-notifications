package fitness;

public class BookingConfirmation extends BookingNotification {

    public BookingConfirmation(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notify(String recipient, String className) {
        String message = "Your booking for " + className + " is confirmed.";
        channel.send(recipient, message);
    }
}