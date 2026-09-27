package fitness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingNotificationTest {

    @Test
    void bookingConfirmationDelegatesToChannel() {
        StubChannel channel = new StubChannel();
        BookingNotification notification =
                new BookingConfirmation(channel);

        notification.notify("MEMBER-101", "Yoga");

        assertEquals("MEMBER-101", channel.recipient);
        assertEquals(
                "Your booking for Yoga is confirmed.",
                channel.message
        );
    }

    @Test
    void cancellationNotificationDelegatesToChannel() {
        StubChannel channel = new StubChannel();
        BookingNotification notification =
                new CancellationNotification(channel);

        notification.notify("MEMBER-202", "Pilates");

        assertEquals("MEMBER-202", channel.recipient);
        assertEquals(
                "Your booking for Pilates is cancelled.",
                channel.message
        );
    }

    private static class StubChannel implements NotificationChannel {

        private String recipient;
        private String message;

        @Override
        public void send(String recipient, String message) {
            this.recipient = recipient;
            this.message = message;
        }
    }
}