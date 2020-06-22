package buttons;

import events.OutsideTempSetEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The Outside temp set button is made using an instance of this class
 *
 */
public class OutsideTempSetButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper display
     * 
     * @param string
     *            the text to be put on the button
     */
    public OutsideTempSetButton(String string) {
        super(string);
    }

    /**
     * Handles the outsideTempSetEvent whenever the button is pressed by informing refridgerator
     * context about the event
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(OutsideTempSetEvent.instance());
    }
}