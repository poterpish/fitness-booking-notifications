package fitness;

public class LegacyGymDisplay {

    public static final int SUCCESS = 0;
    public static final int SCREEN_UNAVAILABLE = -1;
    public static final int INVALID_MEMBER = -2;

    public int showMessage(byte[] message, int screenNumber, String memberCode) {
        if (screenNumber <= 0) {
            return SCREEN_UNAVAILABLE;
        }

        if (memberCode == null || memberCode.isBlank()) {
            return INVALID_MEMBER;
        }

        System.out.println(
                "LEGACY DISPLAY [screen " + screenNumber + "] for "
                        + memberCode + ": " + new String(message)
        );

        return SUCCESS;
    }
}