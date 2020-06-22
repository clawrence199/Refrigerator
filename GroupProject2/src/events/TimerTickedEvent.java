package events;

/**
 * This class represents a clock tick. The clock ticks are used to simulate 
 * cooling and warming
 * 
 * @author Brahma Dathan
 *
 */
public class TimerTickedEvent {
    private int time;

    /**
     * Stores the amount of time passed after the object was created
     * 
     * @param value
     *            the amount of time left
     */
    public TimerTickedEvent(int value) {
        this.time = value;
    }

    /**
     * returns the time field
     */
    public int getTime() {
        return time;
    }
}
