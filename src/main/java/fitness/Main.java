package fitness;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose channel (email/app/display): ");
        String channelType = scanner.nextLine();

        ChannelSelector selector = new ChannelSelector();
        NotificationChannel channel = selector.select(channelType);

        BookingNotification confirmation =
                new BookingConfirmation(channel);

        BookingNotification cancellation =
                new CancellationNotification(channel);

        confirmation.notify("MEMBER-101", "Yoga");
        cancellation.notify("MEMBER-101", "Pilates");
    }
}