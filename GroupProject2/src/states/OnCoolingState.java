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
 * The state where the refrigerator is on and cooling. This is the state that it
 * is in when the refrigerator is first turned on (the on button is pressed)
 *
 */
public class OnCoolingState extends RefrigeratorState implements Notifiable {
	private static OnCoolingState instance;

	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private OnCoolingState() {

	}

	/**
	 * For singleton, retrieves the only instance of this object
	 * 
	 * @return the object
	 */
	public static OnCoolingState instance() {
		if (instance == null) {
			instance = new OnCoolingState();
		}
		return instance;
	}

	/**
	 * Process On button request, Does nothing refrigerator is already on
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {
	}

	/**
	 * Process Off button request, Changes the state to Offstate
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
		RefrigeratorContext.instance().changeState(OffState.instance());
	}

	/**
	 * Process door open request, Changes state to onCoolingOpenState
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {
		RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
	}

	/**
	 * Process door close request, Does nothing because the door is already closed
	 */
	@Override
	public void handleEvent(DoorCloseEvent event) {
		System.out.println("This event does not trigger any changes");
	}

	/**
	 * Process clock tick event, decreases the temperature by at least 1 degree per
	 * second
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
		RefrigeratorContext.instance().decrementFridgeTemp(3 + RefrigeratorContext.instance().environmentEffect(1));
	}

	@Override
	public void handleEvent(Temp3AboveEvent event) {
	}

	/**
	 * Changes the state to OnNotCooling
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {
		RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
	}

	/**
	 * Initializes the state by updating the GUI with the proper values, In this
	 * state the refrigerator is cooling, the power is on, the door is closed, Along
	 * with the light being off.
	 * 
	 */
	@Override
	public void enter() {

		// update the GUI and create a new Timer object
		timer = new Timer(this, 0);
		RefrigeratorContext.instance().showCooling();
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