package com.dannypa.logic;

import com.dannypa.Vector2;

public class Target {
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
