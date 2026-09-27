package fitness;

import java.nio.charset.StandardCharsets;

public class LegacyDisplayAdapter implements NotificationChannel {

    private final LegacyGymDisplay legacyDisplay;
    private final int screenNumber;

    public LegacyDisplayAdapter(LegacyGymDisplay legacyDisplay, int screenNumber) {
        this.legacyDisplay = legacyDisplay;
        this.screenNumber = screenNumber;
    }

    @Override
    public void send(String recipient, String message) {

        byte[] legacyMessage = message.getBytes(StandardCharsets.UTF_8);

        int result = legacyDisplay.showMessage(
                legacyMessage,
                screenNumber,
                recipient
        );

        if (result == LegacyGymDisplay.SCREEN_UNAVAILABLE) {
            throw new NotificationException("Display is unavailable");
        }

        if (result == LegacyGymDisplay.INVALID_MEMBER) {
            throw new NotificationException("Invalid notification recipient");
        }

        if (result != LegacyGymDisplay.SUCCESS) {
            throw new NotificationException("Notification delivery failed");
        }
    }
}