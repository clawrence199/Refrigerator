package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * The abstract GUI JButton object. Helps to get rid of conditionals
 *
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
    /**
     * Create the button with the proper text. Makes the button a listener to
     * clicks on itself.
     * 
     * @param string
     *            the text
     */

    public GUIButton(String string) {
        super(string);
        setOnAction(this);
    }

}