package com.oddfry.actors;

import com.oddfry.R;
import com.oddfry.controls.Controlled;
import com.oddfry.graphics.Animation;
import com.oddfry.logic.RuleGenerator;
import com.oddfry.physics.Direction;
import com.oddfry.physics.Mover;

/**
 * The odd fry, clickable !
 * 
 * @author Guillaume Berard
 *
 */
public class OddFry extends Actor implements Controlled {

	/* PUBLIC */
	/**
	 * Constructor
	 */
	public OddFry() {
		super();
		mover_ = new Mover(this, RuleGenerator.GetInstance().getRule().getOddUpdater());
		anim_ = new Animation(R.drawable.fry_states);
		//TODO, set good img and period
		int tab[] = {0,1,2,3};
		anim_.setAnimation(tab, 100);
		x_ = 100;
		y_ = 100;
	}


	/**
	 * Touched the odd fry?</br>
	 * Warning call once per game, circle the fry when called
	 * @param x
	 * @param y
	 */
	public boolean touched(float x, float y) {
		getDrawer().setCircle(true);
		return (x >= getX() - 10 
				&& x < getX() + getW() + 10
				&& y >= getY() - 10
				&& y < getY() + getH() + 10);
	}


	/* PROTECTED */
	@Override
	protected void lookLeft() {
		if (lastDirection_ != Direction.LEFT) {
			if ( lastPolar_ == Direction.UP) {
				int tab[] = {12,13,14,15};
				anim_.setAnimation(tab, 100);
			} else {
				int tab[] = {0,1,2,3};
				anim_.setAnimation(tab, 100);
			}
			lastDirection_ = Direction.LEFT;
			lastSide_ = Direction.LEFT;
		}
	}


	@Override
	protected void lookRight() {
		if (lastDirection_ != Direction.RIGHT) {
			if ( lastPolar_ == Direction.UP) {
				int tab[] = {8,9,10,11};
				anim_.setAnimation(tab, 100);
			} else {
				int tab[] = {4,5,6,7};
				anim_.setAnimation(tab, 100);
			}
			lastDirection_ = Direction.RIGHT;
			lastSide_ = Direction.RIGHT;
		}
	}


	@Override
	protected void lookUp() {
		if (lastDirection_ != Direction.UP) {
			if ( lastSide_ == Direction.LEFT) {
				int tab[] = {12,13,14,15};
				anim_.setAnimation(tab, 100);
			} else {
				int tab[] = {8,9,10,11};
				anim_.setAnimation(tab, 100);
			}
			lastDirection_ = Direction.UP;
			lastPolar_ = Direction.UP;
		}
	}


	@Override
	protected void lookDown() {
		if (lastDirection_ != Direction.DOWN) {
			if ( lastSide_ == Direction.LEFT) {
				int tab[] = {0,1,2,3};
				anim_.setAnimation(tab, 100);
			} else {
				int tab[] = {4,5,6,7};
				anim_.setAnimation(tab, 100);
			}
			lastDirection_ = Direction.DOWN;
			lastPolar_ = Direction.DOWN;
		}
	}


	/* PRIVATE */
	private Direction lastDirection_;
	private Direction lastPolar_;
	private Direction lastSide_;
}
