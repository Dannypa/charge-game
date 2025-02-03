package com.dannypa.logic;

import com.dannypa.Vector2;

import java.util.ArrayList;

public class GameMechanic {
    public static double DT = 1.0D / 60;

    private final double accelerationConstant = 1;
    private final BallControls ballControls;
    private final TargetControls targetControls;
    private final int TARGET_NUM = 2;

    private final ArrayList<Charge> charges = new ArrayList<>();

    public GameMechanic(int width, int height, int padding, int ballOffset) {
        ballControls = new BallControls(new Vector2(ballOffset, height - padding - ballOffset));
        targetControls = new TargetControls(TARGET_NUM, width, height, padding);
    }

    public void addCharge(Charge c) {
        charges.add(c);
    }

    public void update() {
        ballControls.update(DT, charges);
        targetControls.update(ballControls.ballPosition());
    }

    public boolean isWon() {
        return targetControls.allHit();
    }

    public Target[] targets() {
        return targetControls.targets();
    }

    public Charge[] charges() {
        return charges.toArray(Charge[]::new); // don't want user's to change that
    }

    public Vector2 ballPosition() {
        return ballControls.ballPosition();
    }
}