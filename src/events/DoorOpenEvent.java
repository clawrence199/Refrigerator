package events;

/**
 * Represents the door open operation
 *
 */
public class DoorOpenEvent {
    private static DoorOpenEvent instance;

    /**
     * Private for singleton
     * 
     */
    private DoorOpenEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static DoorOpenEvent instance() {
        if (instance == null) {
            instance = new DoorOpenEvent();
        }
        return instance;
    }
}