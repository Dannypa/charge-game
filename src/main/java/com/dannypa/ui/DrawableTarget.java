package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.logic.Target;

import java.awt.*;

public class DrawableTarget implements Drawable {
    private final Color HIT_TARGET_COLOR = new Color(17, 69, 48);
    private final Color UNHIT_TARGET_COLOR = new Color(255, 255, 0);

    private final Target target;

    public DrawableTarget(Target t) {
        target = t;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (target.hit()) {
            g2d.setColor(HIT_TARGET_COLOR);
        } else {
            g2d.setColor(UNHIT_TARGET_COLOR);
        }
        g2d.fillOval(
                (int) target.position().x(),
                (int) target.position().y(),
                Constants.TARGET_SIZE,
                Constants.TARGET_SIZE
        );
    }
}
