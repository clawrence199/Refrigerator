package application;

import display.GUIDisplay;
import display.RefrigeratorDisplay;
import javafx.application.Application;
import states.RefrigeratorContext;
import timer.Clock;

/**
 * Main method starts the interactions between all our classes,
 * thats by creating new Clock instances and a new thread. Application is 
 * then run.
 * @author armando
 *
 */
public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, null);
            }
        }.start();
        try {
            while (GUIDisplay.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        RefrigeratorDisplay display = GUIDisplay.getInstance();
        RefrigeratorContext.instance().setDisplay(display);
    } 
}
