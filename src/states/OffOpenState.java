package states;

import events.DoorCloseEvent;
import events.DoorOpenEvent;
import events.OffRequestEvent;
import events.OnRequestEvent;
import events.Temp3AboveEvent;
import events.Temp3BelowEvent;
import events.TimerTickedEvent;
import timer.Notifiable;

/**
 * The state where the refrigerator is off and the door is open.
 *
 */
public class OffOpenState extends RefrigeratorState implements Notifiable {
	private static OffOpenState instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private OffOpenState() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static OffOpenState instance() {
		if (instance == null) {
			instance = new OffOpenState();
		}
		return instance;
	}

	/**
	 * Process on button request, This does nothing as door is already opened
	 */
	@Override
	public void handleEvent(OnRequestEvent event) {
		System.out.println("This event does not trigger any changes");
	}

	/**
	 * Process off button request, This does nothing as refrigerator is already off
	 */
	@Override
	public void handleEvent(OffRequestEvent event) {

	}

	/**
	 * Process door open request, this does nothing as the refrigerator door is
	 * already open
	 */
	@Override
	public void handleEvent(DoorOpenEvent event) {
	}

	/**
	 * Process door close request, Changes the state to OffState
	 */
	@Override
	public void handleEvent(DoorCloseEvent event) {
		RefrigeratorContext.instance().changeState(OffState.instance());
	}

	/**
	 * Process clock tick event, This does nothing refrigerator is off
	 */
	@Override
	public void handleEvent(TimerTickedEvent event) {
	}

	/**
	 * process the 3 degrees above event, This does nothing as the refrigerator is
	 * off
	 */
	@Override
	public void handleEvent(Temp3AboveEvent event) {

	}

	/**
	 * process the 3 degrees below event, This does nothing as the refrigerator is
	 * off
	 */
	@Override
	public void handleEvent(Temp3BelowEvent event) {

	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * displays. In this state the refrigerator is not cooling, the door is open,
	 * the light is on and the power is off.
	 * 
	 */
	@Override
	public void enter() {

		// update the GUI with correct values
		RefrigeratorContext.instance().showNotCooling();
		RefrigeratorContext.instance().showDoorOpened();
		RefrigeratorContext.instance().showLightOff();
		RefrigeratorContext.instance().showPowerOff();
	}

	/**
	 * Handles any cleanup needed for this state.
	 */
	@Override
	public void leave() {
	}

}