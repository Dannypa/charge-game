package com.dannypa.logic;

import com.dannypa.Constants;
import com.dannypa.Vector2;

import java.util.Arrays;

class TargetControls {
    private final Target[] targets;
    private int hitCount = 0;
    private final double EPS = 1;

    public TargetControls(int targetNumber, int width, int height, int padding) {
        targets = new Target[targetNumber];
        for (int i = 0; i < targetNumber; i++) {
            targets[i] = new Target(Utility.generatePosition(width, height, padding));
        }
    }

    private boolean isColliding(Vector2 ballPosition, Vector2 targetPosition) {
        Vector2 ballCenter = Utility.getCenter(ballPosition, Constants.BALL_SIZE);
        Vector2 targetCenter = Utility.getCenter(targetPosition, Constants.TARGET_SIZE);
        return (ballCenter.sub(targetCenter)).getSqLength()
                <= Math.pow((Constants.BALL_SIZE + Constants.TARGET_SIZE) / 2.0, 2);
    }


    public void update(Vector2 ballPosition) {
        for (Target t : targets) {
            if (!t.hit() && isColliding(ballPosition, t.position())) {
                t.hitTarget();
                hitCount++;
            }
        }
    }

    public boolean allHit() {
        return hitCount == targets.length;
    }

    public Target[] targets() {
        return Arrays.copyOf(targets, targets.length); // don't want the user to change it
    }
}

