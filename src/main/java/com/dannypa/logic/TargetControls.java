package com.dannypa.logic;

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


    public void update(Vector2 ballPosition) {
        for (Target t : targets) {
            if (!t.hit() && t.position().sub(ballPosition).getSqLength() <= EPS) {
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

