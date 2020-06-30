package events;

/**
 * Represents setting the desired temp
 *
 */
public class DesiredTempSetEvent {
    private static DesiredTempSetEvent instance;

    /**
     * Private for singleton
     * 
     */
    private DesiredTempSetEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static DesiredTempSetEvent instance() {
        if (instance == null) {
            instance = new DesiredTempSetEvent();
        }
        return instance;
    }
}