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
 * The State where the refrigerator is not cooling and the door is open. The
 * refrigerator temperature approaches the outside temperature by two degrees
 * per second in this state
 * 
 */
public class OnNotCoolingOpenState extends RefrigeratorState implements Notifiable {
	private static OnNotCoolingOpenState instance;
	private Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	private OnNotCoolingOpenState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static OnNotCoolingOpenState instance() {
		if (instance == null) {
			instance = new OnNotCoolingOpenState();
		}
		return instance;
	}

	/**
	 * Process On button request, This does nothing because the refrigerator is
	 * already on
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {

	}

	/**
	 * Process Off button request, changes the state to OffOpenState
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {
		RefrigeratorContext.instance().changeState(OffOpenState.instance());
	}

	/**
	 * Process door open request, the door is already open this does nothing
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {

	}

	/**
	 * Process door close request, changes the state to OnNotCoolingState
	 */
	@Override
	public void handleEvent(DoorCloseEvent event) {
		RefrigeratorContext.instance().changeState(OnNotCoolingState.instance());
	}

	/**
	 * Process the event where the internal temperature is 3 degrees higher than the
	 * desired temperature.
	 */
	@Override
	public void handleEvent(Temp3AboveEvent event) {
		RefrigeratorContext.instance().changeState(OnCoolingOpenState.instance());
	}

	/**
	 * Process the event where the internal temperature is 3 degrees lower than the
	 * desired temperature.
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {

	}

	/**
	 * Process clock tick event, because the refridgerator's door is open and it is
	 * not cooling this means that the refrigerator temperature will be more
	 * susceptible to the outside temperature
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {

		RefrigeratorContext.instance().decrementFridgeTemp(RefrigeratorContext.instance().environmentEffect(2));
	}

	/**
	 * Initializes the state, displays the GUI with the proper values, In this state
	 * the refrigerator is not cooling the power is on, the door is opened and the
	 * light is on
	 * 
	 */
	@Override
	public void enter() {
		timer = new Timer(this, 0);
		RefrigeratorContext.instance().showNotCooling();
		RefrigeratorContext.instance().showPowerOn();
		RefrigeratorContext.instance().showDoorOpened();
		RefrigeratorContext.instance().showLightOn();
		RefrigeratorContext.instance().showFridgeTemp(RefrigeratorContext.instance().getFridgeTemp());
		RefrigeratorContext.instance().showOutsideTemp(RefrigeratorContext.instance().getOutsideTemp());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
