package display;

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface RefrigeratorDisplay {

	/**
     * Indicate that the light is on
     */
    public void showPowerOn();
    /**
     * Indicate that the light is on
     */
    public void showPowerOff();
    
    /**
     * Indicate that the light is on
     */
    public void showLightOn();

    /**
     * Indicate that the light is off
     */
    public void showLightOff();

    /**
     * Indicate that the door is now closed
     */
    public void showDoorClosed();

    /**
     * Indicate that the door is now open
     */
    public void showDoorOpened();

    /**
     * indicate that cooking has begun
     */
    public void showCooling();

    /*
     * indicate that cooking has ended
     */
    public void showNotCooling();
    
    /**
     * indicate that cooking has ended
     */
    public void showOutsideTemp(int temp);
    
    /**
     * indicate that cooking has ended
     */
    public void showFridgeTemp(int temp);
    
    /**
     * take in user values for desired temp
     * @return an int for the desired temp
     */
    public int getDesiredField();
    
    /**
     * take in user values for outside temp
     * @return an int for the outside temp
     */
    public int getOutsideField();
   

}