package buttons;

import events.DesiredTempSetEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.RefrigeratorContext;

/**
 * The setting the desired temp is made using an instance of this class
 *
 */
public class DesiredTempSetButton extends GUIButton implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper display
     * 
     * @param string
     *            the text to be put on the button
     */
    public DesiredTempSetButton(String string) {
        super(string);
    }
    
    
    /**
     * triggered when the desired temp text box is set to another value and by 
     * telling the refridgerator about this event
     */
    @Override
    public void handle(ActionEvent event) {
        RefrigeratorContext.instance().handleEvent(DesiredTempSetEvent.instance());
        
    }
}