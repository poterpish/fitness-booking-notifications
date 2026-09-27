package fitness;

public class ChannelSelector {

    public NotificationChannel select(String channelType) {
        return switch (channelType.toLowerCase()) {
            case "email" -> new EmailChannel();
            case "app" -> new AppChannel();
            case "display" -> new LegacyDisplayAdapter(
                    new LegacyGymDisplay(),
                    1
            );
            default -> throw new IllegalArgumentException(
                    "Unknown channel: " + channelType
            );
        };
    }
}