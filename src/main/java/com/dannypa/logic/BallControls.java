package com.dannypa.logic;

import com.dannypa.Vector2;

import java.util.ArrayList;

class BallControls {
    private final double ACCELERATION_CONSTANT = 1e5;
    private final double EPS = 10;

    private Vector2 position;
    private Vector2 speed = new Vector2(0, 0);
    private Vector2 acceleration = new Vector2(0, 0);

    private final Vector2 initialPosition;

    private boolean isMoving = false;

    public BallControls(Vector2 initialPosition) {
        this.initialPosition = initialPosition;
        this.position = initialPosition;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public Vector2 ballPosition() {
        return position;
    }

    private Vector2 getAcceleration(Charge c) {
        Vector2 chargeToBall = position.sub(c.position());
        if (chargeToBall.getSqLength() < EPS) {
            return new Vector2(0, 0);
        }
        double addedAccelerationMagnitude = ACCELERATION_CONSTANT * c.getSign() / chargeToBall.getSqLength();
        return chargeToBall.scale(addedAccelerationMagnitude);
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
        position = position.add(speed.scale(dt));
    }

    public void update(double dt, ArrayList<Charge> charges) {
        if (isMoving) {
            updateAcceleration(charges);
            updateSpeed(dt);
            updatePosition(dt);
        }
    }

    public void setSpeed(Vector2 newSpeed) {
        speed = newSpeed;
    }

    public void reset() {
        position = initialPosition;
        speed = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        isMoving = false;
    }
}