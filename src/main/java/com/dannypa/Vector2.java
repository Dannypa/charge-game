package com.dannypa;

public class Vector2 {
    final public static double EPS = 1e-15;
    final private double x, y;

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "; " + y;
    }

    public Vector2 add(Vector2 b) {
        return new Vector2(this.x + b.x, this.y + b.y);
    }

    public Vector2 neg() {
        return new Vector2(-x, -y);
    }

    public Vector2 sub(Vector2 b) {
        return add(b.neg());
    }

    public double getSqLength() {
        return x * x + y * y;
    }

    public double getLength() {
        return Math.sqrt(this.getSqLength());
    }

    public Vector2 scale(double k) {
        return new Vector2(x * k, y * k);
    }

    public double multScalar(Vector2 b) {
        return x * b.x + y * b.y;
    }

    public double getCos(Vector2 b) {
        if (getLength() * b.getLength() < EPS) {
            return 1;
        }
        return multScalar(b) / (getLength() * b.getLength());
    }

    public Vector2 getUnit() {
        return this.scale(1 / this.getLength());
    }
}