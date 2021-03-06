package com.oddfry.logic;

import com.oddfry.globals.Globals;
import com.oddfry.graphics.Screen;
import com.oddfry.physics.MoveUpdater;

/**
 * Class that represents a game rule.</br>
 * It defines how normal fries and the odd fry
 * behave or look like.
 * 
 * @author Guillaume Berard
 *
 */
public abstract class Rule {
	/* PUBLIC */
	/**
	 * Get the updater for the behavior of normal fries
	 * @return updater
	 */
	public abstract MoveUpdater getNormalUpdater();
	
	
	/**
	 * Get the updater for the behavior of the odd fry
	 * @return
	 */
	public abstract MoveUpdater getOddUpdater();
	
	
	/**
	 * 
	 * @return
	 */
	public abstract int getTimeToSolve();
	
	
	/**
	 * Get random x for odd fry
	 * @return
	 */
	public float getX() {
		return Globals.GetInstance().
				getRand().nextFloat()*Screen.GetInstance().getW();
	}


	/**
	 * Get random y for odd fry
	 * @return
	 */
	public float getY() {
		return Globals.GetInstance().
				getRand().nextFloat()*Screen.GetInstance().getH();
	}
}
