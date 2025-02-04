package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.logic.Charge;

import java.awt.*;

public class DrawableCharge implements Drawable {
    private final Color POSITIVE_COLOR = Color.RED;
    private final Color NEGATIVE_COLOR = Color.BLUE;

    private final Charge charge;

    DrawableCharge(Charge c) {
        charge = c;
    }

    @Override
    public void draw(Graphics2D g2d) {
        if (charge.getSign() > 0) {
            g2d.setColor(POSITIVE_COLOR);
        } else {
            g2d.setColor(NEGATIVE_COLOR);
        }
        g2d.fillOval(
                (int) charge.position().x(),
                (int) charge.position().y(),
                Constants.CHARGE_SIZE,
                Constants.CHARGE_SIZE
        );
    }
}
