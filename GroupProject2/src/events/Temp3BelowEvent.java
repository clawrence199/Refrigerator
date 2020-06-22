package events;

/**
 * Event class to specify that this event has occured.
 * @author armando
 *
 */
public class Temp3BelowEvent {
	
	  private static Temp3BelowEvent instance;

	    /**
	     * Private for singleton
	     * 
	     */
	    private Temp3BelowEvent() {

	    }

	    /**
	     * For the singleton pattern
	     * 
	     * @return the only instance
	     */
	    public static Temp3BelowEvent instance() {
	        if (instance == null) {
	            instance = new Temp3BelowEvent();
	        }
	        return instance;
	    }
}
