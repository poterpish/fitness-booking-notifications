package fitness;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LegacyDisplayAdapterTest {

    @Test
    void translatesScreenUnavailableFailure() {
        LegacyGymDisplay legacyDisplay = new LegacyGymDisplay();

        NotificationChannel adapter =
                new LegacyDisplayAdapter(legacyDisplay, 0);

        assertThrows(
                NotificationException.class,
                () -> adapter.send("MEMBER-101", "Test message")
        );
    }

    @Test
    void translatesInvalidMemberFailure() {
        LegacyGymDisplay legacyDisplay = new LegacyGymDisplay();

        NotificationChannel adapter =
                new LegacyDisplayAdapter(legacyDisplay, 1);

        assertThrows(
                NotificationException.class,
                () -> adapter.send("", "Test message")
        );
    }
}