package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.logic.Charge;
import com.dannypa.logic.GameMechanic;
import com.dannypa.logic.Target;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameMechanic gm;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        g2d.setColor(Color.GREEN);
        g2d.fillOval((int) gm.ballPosition().x(), (int) gm.ballPosition().y(), Constants.BALL_SIZE, Constants.BALL_SIZE);

        g2d.setColor(Color.BLACK);
        for (Target t : gm.targets()) {
            g2d.fillOval((int) t.position().x(), (int) t.position().y(), Constants.TARGET_SIZE, Constants.TARGET_SIZE);
        }

        g2d.setColor(Color.RED);
        for (Charge c : gm.charges()) {
            g2d.fillOval((int) c.position().x(), (int) c.position().y(), Constants.CHARGE_SIZE, Constants.CHARGE_SIZE);
        }
    }

    public GamePanel(GameMechanic gm) {
        this.gm = gm;

        this.setBorder(new LineBorder(Color.BLACK, 5));
    }
}
