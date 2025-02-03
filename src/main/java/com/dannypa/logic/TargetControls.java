package com.dannypa.logic;

import com.dannypa.Vector2;

class Target {
    private boolean hit = false;
    private final Vector2 position;

    public Target(Vector2 position) {
        this.position = position;
    }

    public boolean hit() {
        return hit;
    }

    public Vector2 position() {
        return position;
    }

    public void hitTarget() {
        hit = true;
    }
}

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
}

