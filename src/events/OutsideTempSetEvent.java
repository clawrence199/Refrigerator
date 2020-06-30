package events;

/**
 * Represents setting the outside temp
 *
 */
public class OutsideTempSetEvent {
    private static OutsideTempSetEvent instance;

    /**
     * Private for singleton
     * 
     */
    private OutsideTempSetEvent() {

    }

    /**
     * For the singleton pattern
     * 
     * @return the only instance
     */
    public static OutsideTempSetEvent instance() {
        if (instance == null) {
            instance = new OutsideTempSetEvent();
        }
        return instance;
    }
}