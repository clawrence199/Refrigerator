package events;

/**
 * Represents the off button request
 *
 */
public class OffRequestEvent {
    private static OffRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private OffRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static OffRequestEvent instance() {
        if (instance == null) {
            instance = new OffRequestEvent();
        }
        return instance;
    }
}