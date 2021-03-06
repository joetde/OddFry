package com.oddfry.logic;

import com.oddfry.physics.MoveUpdater;
import com.oddfry.physics.MoveUpdaterCircleAnticlockwise;
import com.oddfry.physics.MoveUpdaterCircleClockwise;

public class RuleCircle extends Rule {

	@Override
	public MoveUpdater getNormalUpdater() {
		return new MoveUpdaterCircleAnticlockwise();
	}

	@Override
	public MoveUpdater getOddUpdater() {
		return new MoveUpdaterCircleClockwise();
	}

	@Override
	public int getTimeToSolve() {
		return 10000;
	}
}
