package buttons;

import events.DoorCloseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * For creating the door close button
 *
 */
public class DoorCloseButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * Creates the button with the required label
     * 
     * @param string
     *            the label for the button
     */

    public DoorCloseButton(String string) {
        super(string);
    }

    /**
     * Handles the DoorCloseEvent by telling the refridgerator that the button has been pressed
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DoorCloseEvent.instance());
    }
}