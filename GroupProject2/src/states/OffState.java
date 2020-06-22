package states;

import events.DoorOpenEvent;
import events.OffRequestEvent;
import events.OnRequestEvent;
import events.Temp3AboveEvent;
import events.Temp3BelowEvent;
import events.TimerTickedEvent;
import timer.Notifiable;

/**
 * The state where the refrigerator is off and the door is closed. this is the
 * state that the refrigerator starts in
 *
 */
public class OffState extends RefrigeratorState implements Notifiable {
	private static OffState instance;

	/**
	 * Private for the singleton pattern
	 */
	private OffState() {
	}

	/**
	 * For singleton pattern, returns the only instance of this class
	 * 
	 * @return the object
	 */
	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
		}
		return instance;
	}

	/**
	 * Process on request, changes the state to the onCoolingState when this event
	 * occurs.
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {

		RefrigeratorContext.instance().changeState(OnCoolingState.instance());
	}

	/**
	 * Process off request, this does nothing as the refrigerator is off.
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
	}

	/**
	 * Process door open request, changes the state to the OffOpenState.
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {
		RefrigeratorContext.instance().changeState(OffOpenState.instance());
	}

	/**
	 * Process clock tick event, This does nothing to our state as refrigerator is
	 * off, displays message to console for debugging purposes
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
	}

	/**
	 * Process the 3 degrees above event, This does nothing
	 */
	@Override
	public void handleEvent(Temp3AboveEvent event) {
	}

	/**
	 * Process the 3 degrees below event, This does nothing
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {
	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * displays
	 * 
	 */
	@Override
	public void enter() {
		RefrigeratorContext.instance().showPowerOff();
		RefrigeratorContext.instance().showNotCooling();
		RefrigeratorContext.instance().showLightOff();
		RefrigeratorContext.instance().showDoorClosed();
	}

	@Override
	public void leave() {
	}

}