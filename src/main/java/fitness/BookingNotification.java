package fitness;

public abstract class BookingNotification {

    protected final NotificationChannel channel;

    public BookingNotification(NotificationChannel channel) {
        this.channel = channel;
    }

    public abstract void notify(String recipient, String className);
}