package com.dannypa.logic;

import java.util.ArrayList;

class GameMechanic {
    public static double DT = 1.0D / 60;

    private final double accelerationConstant = 1;
    private final BallControls ballControls;
    private final TargetControls targetControls;
    private final int TARGET_NUM = 2;

    private final ArrayList<Charge> charges = new ArrayList<>();

    public GameMechanic(int width, int height, int padding) {
        ballControls = new BallControls(Utility.generatePosition(width, height, padding));
        targetControls = new TargetControls(TARGET_NUM, width, height, padding);
    }

    public void addCharge(Charge c) {
        charges.add(c);
    }

    public void update() {
        ballControls.update(DT, charges);
        targetControls.update(ballControls.getBallPosition());
    }

    public boolean isWon() {
        return targetControls.allHit();
    }
}