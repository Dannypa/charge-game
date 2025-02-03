package com.dannypa.logic;

import com.dannypa.Vector2;

public class Charge {
    private final Vector2 p;
    private final int sign;

    public int getSign() {
        return sign;
    }

    public Vector2 position() {
        return p;
    }

    public Charge(Vector2 p, int sign) {
        this.p = p;
        this.sign = sign;
    }
}
