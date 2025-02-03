package com.dannypa.logic;

import com.dannypa.Vector2;

import java.util.Random;

class Utility {
    public static Random r = new Random(42);

    public static Vector2 generatePosition(int width, int height, int padding) {
        return new Vector2(r.nextInt(padding, width - padding), r.nextInt(padding, height - padding));
    }
}