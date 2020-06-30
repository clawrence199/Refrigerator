package buttons;

import events.OnRequestEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The on button
 *
 */
public class OnButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * The on button
     * 
     * @param string
     */
    public OnButton(String string) {
        super(string);
    }

    /**
     * Handles the off request whenever the button is pressed by informing refridgerator
     * context about the event
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(OnRequestEvent.instance());
    }
}