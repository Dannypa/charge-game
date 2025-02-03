package com.dannypa.logic;

import com.dannypa.Vector2;

import java.util.ArrayList;

class BallControls {
    private Vector2 position;
    private Vector2 speed = new Vector2(0, 0);
    private Vector2 acceleration = new Vector2(0, 0);

    public BallControls(Vector2 initialPosition) {
        this.position = initialPosition;
    }

    public Vector2 ballPosition() {
        return position;
    }

    private Vector2 getAcceleration(Charge c) {
        Vector2 chargeToBall = position.sub(c.position());
        if (chargeToBall.getSqLength() < Vector2.EPS) {
            return new Vector2(0, 0);
        }
        double addedAccelerationMagnitude = c.getSign() / chargeToBall.getSqLength();
        return chargeToBall.scale(addedAccelerationMagnitude / chargeToBall.getLength());
    }

    private void updateAcceleration(ArrayList<Charge> charges) {
        acceleration = new Vector2(0, 0);
        for (Charge c : charges) {
            acceleration = acceleration.add(getAcceleration(c));
        }
    }

    private void updateSpeed(double dt) {
        speed = speed.add(acceleration.scale(dt));
    }

    private void updatePosition(double dt) {
        position.add(speed.scale(dt));
    }

    public void update(double dt, ArrayList<Charge> charges) {
        updateAcceleration(charges);
        updateSpeed(dt);
        updatePosition(dt);
    }
}