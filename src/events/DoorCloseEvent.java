package events;

/**
 * Represents the door close operation
 *
 */
public class DoorCloseEvent {
    private static DoorCloseEvent instance;

    /**
     * Private for singleton
     * 
     */
    private DoorCloseEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static DoorCloseEvent instance() {
        if (instance == null) {
            instance = new DoorCloseEvent();
        }
        return instance;
    }
}