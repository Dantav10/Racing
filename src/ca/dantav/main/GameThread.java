package ca.dantav.main;

/**
 * The Game Thread
 * TODO find better way to do this
 */
public final class GameThread implements Runnable {

	/**
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		/** Constantly loops */
		while(true) {
		
		try {
			
			/** Repaints the screen */
			Panel.PANEL.repaint();
			Thread.sleep(50);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}

}
