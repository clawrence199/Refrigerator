package states;

import events.DoorCloseEvent;
import events.DoorOpenEvent;
import events.OffRequestEvent;
import events.OnRequestEvent;
import events.Temp3AboveEvent;
import events.Temp3BelowEvent;
import events.TimerTickedEvent;
import timer.Notifiable;
import timer.Timer;

/**
 * The State where the refrigerator is on and not cooling. The refrigerator
 * temperature approaches the outside temperature.
 * 
 */
public class OnNotCoolingState extends RefrigeratorState implements Notifiable {
	private static OnNotCoolingState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private OnNotCoolingState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static OnNotCoolingState instance() {
		if (instance == null) {
			instance = new OnNotCoolingState();
		}
		return instance;
	}

	/**
	 * Process On button request, Does nothing as the refrigerator is already on
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {

	}

	/**
	 * Process Off button request, changes the state to OffState
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
		RefrigeratorContext.instance().changeState(OffState.instance());
	}

	/**
	 * Process door open request, changes the state to OnNotCoolingOpenState
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {
		RefrigeratorContext.instance().changeState(OnNotCoolingOpenState.instance());
	}

	/**
	 * Process door close request, does nothing as the door is already closed
	 */
	@Override
	public void handleEvent(DoorCloseEvent event) {

	}

	/**
	 * Process the event where the internal temperature is 3 degrees higher than the
	 * desired temperature.
	 */
	public void handleEvent(Temp3AboveEvent event) {
		RefrigeratorContext.instance().changeState(OnCoolingState.instance());
	}

	/**
	 * Process the event where the internal temperature is 3 degrees lower than the
	 * desired temperature.
	 */
	public void handleEvent(Temp3BelowEvent event) {

	}

	/**
	 * Process clock tick event, while the refrigerator is not on, the temperature
	 * will approach the outdoor temperature.
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {

		// Change the temperature according to the outside temperature
		RefrigeratorContext.instance().decrementFridgeTemp(RefrigeratorContext.instance().environmentEffect(1));
	}

	/**
	 * Initializes the state and adds itself as a listener to managers. Also updates
	 * the displays
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 0);
		RefrigeratorContext.instance().showNotCooling();
		RefrigeratorContext.instance().showPowerOn();
		RefrigeratorContext.instance().showDoorClosed();
		RefrigeratorContext.instance().showLightOff();
		RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
		RefrigeratorContext.instance().showOutsideTemp(RefrigeratorContext.instance().getOutsideTemp());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
