package com.dannypa;

class Charge {
    final Vector2 p;
    final int sign;

    public int getSign() {
        return sign;
    }

    public Vector2 getPosition() {
        return p;
    }

    Charge(Vector2 p, int sign) {
        this.p = p;
        this.sign = sign;
    }
}
