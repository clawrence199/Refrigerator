package events;

/**
 * Event class to specify that this event has occured.
 * @author armando
 *
 */
public class Temp3AboveEvent {
	
	  private static Temp3AboveEvent instance;

	    /**
	     * Private for singleton
	     * 
	     */
	    private Temp3AboveEvent() {

	    }

	    /**
	     * For the singleton pattern
	     * 
	     * @return the only instance
	     */
	    public static Temp3AboveEvent instance() {
	        if (instance == null) {
	            instance = new Temp3AboveEvent();
	        }
	        return instance;
	    }
}
