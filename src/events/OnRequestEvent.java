package events;

/**
 * Represents the on button request
 *
 */
public class OnRequestEvent {
    private static OnRequestEvent instance;

    /**
     * Private for singleton
     * 
     */
    private OnRequestEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static OnRequestEvent instance() {
        if (instance == null) {
            instance = new OnRequestEvent();
        }
        return instance;
    }
}