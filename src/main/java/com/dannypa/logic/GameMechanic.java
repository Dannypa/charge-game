package com.dannypa.logic;

import com.dannypa.Main;
import com.dannypa.Vector2;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameMechanic {
    public static double DT = 1.0D / 120;

    private final double SPEED_CONVERSION_CONSTANT = 20;

    private final BallControls ballControls;
    private final TargetControls targetControls;
    private final int TARGET_NUM = 2;

    private final ArrayList<Charge> charges = new ArrayList<>();

    private final double DEFAULT_ANGLE = -Math.PI / 4;

    private int attemptCounter = 0;


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

    public int attemptCounter() {
        return attemptCounter;
    }

    public void onReset() {
        charges.clear();
        ballControls.reset();
        attemptCounter++;
    }

    public void onLaunch(int newSpeed) {
        Vector2 vectorSpeed = new Vector2(newSpeed * Math.cos(DEFAULT_ANGLE), newSpeed * Math.sin(DEFAULT_ANGLE))
                .scale(SPEED_CONVERSION_CONSTANT);
        ballControls.setSpeed(vectorSpeed);
        ballControls.setIsMoving(true);
    }

    public void onClick(Vector2 mousePosition, int mouseButton) {
        if (mouseButton == MouseEvent.BUTTON1) {
            addCharge(new Charge(mousePosition, +1));
        } else if (mouseButton == MouseEvent.BUTTON2) {
            addCharge(new Charge(mousePosition, -1));
        }
    }
}