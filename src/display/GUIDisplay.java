package display;

import buttons.DesiredTempSetButton;
import buttons.DoorCloseButton;
import buttons.DoorOpenButton;
import buttons.GUIButton;
import buttons.OffButton;
import buttons.OnButton;
import buttons.OutsideTempSetButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.RefrigeratorContext;

/**
 * GUI to implement the RefrigeratorDisplay interface.
 */
public class GUIDisplay extends Application implements RefrigeratorDisplay {
	private GUIButton doorCloser;
	private GUIButton doorOpener;
	private GUIButton onButton;
	private GUIButton offButton;
	private GUIButton outsideTempSet;
	private GUIButton desiredTempSet;

	private Text doorStatus = new Text("Door Closed");
	private Text coolingStatus = new Text("Not cooling");
	private Text outsideTempValue = new Text("Outside Temp");
	private Text lightStatus = new Text("Light Off");
	private Text powerStatus = new Text("Fridge Off");
	private Text fridgeTemp = new Text("Fridge Temp");
	private TextField outsideTempField = new TextField();
	private TextField desiredTempField = new TextField();

	private static RefrigeratorDisplay display;
	private RefrigeratorContext refrigeratorContext;

	public static RefrigeratorDisplay getInstance() {
		return display;
	}

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		refrigeratorContext = RefrigeratorContext.instance();
		refrigeratorContext.setDisplay(this);
		display = this;
		doorCloser = new DoorCloseButton("Close door");
		doorOpener = new DoorOpenButton("Open door");
		onButton = new OnButton("On");
		offButton = new OffButton("Off");
		outsideTempSet = new OutsideTempSetButton("Set Outside Temp");
		desiredTempSet = new DesiredTempSetButton("Set Desired Fridge Temp");

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(coolingStatus, 0, 0);
		pane.add(fridgeTemp, 2, 0);
		pane.add(outsideTempValue, 4, 0);
		pane.add(lightStatus, 6, 0);
		pane.add(powerStatus, 7, 0);
		pane.add(doorStatus, 8, 0);
		pane.add(doorCloser, 0, 2);
		pane.add(doorOpener, 2, 2);
		pane.add(onButton, 4, 2);
		pane.add(offButton, 6, 2);
		pane.add(outsideTempField, 0, 3);
		pane.add(outsideTempSet, 2, 3);
		pane.add(desiredTempField, 4, 3);
		pane.add(desiredTempSet, 6, 3);

		showDoorClosed();
		showLightOff();
		showNotCooling();
		showPowerOff();

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Refrigerator");
		try {
			while (refrigeratorContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	/**
	 * Indicate that the refrigerator is on
	 */
	@Override
	public void showPowerOn() {
		powerStatus.setText("Fridge On");
	}

	/**
	 * Indicate that the refrigerator is off
	 */
	@Override
	public void showPowerOff() {
		powerStatus.setText("Fridge Off");
	}

	/**
	 * Indicate that the light is on
	 */
	@Override
	public void showLightOn() {
		lightStatus.setText("Light On");
	}

	/**
	 * Indicate that the light is off
	 */
	@Override
	public void showLightOff() {
		lightStatus.setText("Light Off");
	}

	/**
	 * Indicate that the door is closed
	 */
	@Override
	public void showDoorClosed() {
		doorStatus.setText("Door Closed");
	}

	/**
	 * Indicate that the door is opened
	 */
	@Override
	public void showDoorOpened() {
		doorStatus.setText("Door Opened");
	}

	/**
	 * display the outside temperature
	 * 
	 * @param the temperature
	 */
	@Override
	public void showOutsideTemp(int value) {
		outsideTempValue.setText("Outside Temp: " + value);
	}

	/**
	 * display the refrigerator temperature
	 * 
	 * @param the temperature
	 */
	@Override
	public void showFridgeTemp(int value) {
		fridgeTemp.setText("Fridge Temp: " + value);
	}

	/**
	 * Indicate that the refrigerator is cooling
	 */
	@Override
	public void showCooling() {
		coolingStatus.setText("Cooling");
	}

	/**
	 * Indicate that the refrigerator is not cooling
	 */
	@Override
	public void showNotCooling() {
		coolingStatus.setText("Not cooling");
	}

	/**
	 * Takes in string from user and
	 * 
	 * @return An integer representing desired temperature
	 */
	public int getDesiredField() {
		String desiredTemp = desiredTempField.getText();
		return Integer.parseInt(desiredTemp);
	}

	/**
	 * Takes in string from user and
	 * 
	 * @return An integer representing outside temperature
	 */
	public int getOutsideField() {
		String outsideTemp = outsideTempField.getText();
		return Integer.parseInt(outsideTemp);
	}

}
