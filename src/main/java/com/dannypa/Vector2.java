package com.dannypa;

class Vector2 {
    final private double EPS = 1e-15;
    final double x, y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void print() {
        System.out.println(x + " " + y);
    }

    Vector2 add(Vector2 b) {
        return new Vector2(this.x + b.x, this.y + b.y);
    }

    Vector2 neg() {
        return new Vector2(-x, -y);
    }

    Vector2 sub(Vector2 b) {
        return add(b.neg());
    }

    double getSqLength() {
        return x * x + y * y;
    }

    double getLength() {
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
}