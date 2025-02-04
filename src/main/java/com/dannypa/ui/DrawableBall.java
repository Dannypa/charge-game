package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.Vector2;

import java.awt.*;

public class DrawableBall implements Drawable {
    private final Color BALL_COLOR = Color.GREEN;

    private final Vector2 ballPosition;

    public DrawableBall(Vector2 ballPosition) {
        this.ballPosition = ballPosition;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(BALL_COLOR);
        g2d.fillOval(
                (int) ballPosition.x(),
                (int) ballPosition.y(),
                Constants.BALL_SIZE,
                Constants.BALL_SIZE
        );
    }
}
