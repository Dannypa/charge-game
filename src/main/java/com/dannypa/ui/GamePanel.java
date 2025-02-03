package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.Vector2;
import com.dannypa.logic.Charge;
import com.dannypa.logic.GameMechanic;
import com.dannypa.logic.Target;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private final Color HIT_TARGET_COLOR = new Color(17, 69, 48);
    private final Color UNHIT_TARGET_COLOR = new Color(255, 255, 0);

    private final Color POSITIVE_COLOR = Color.RED;
    private final Color NEGATIVE_COLOR = Color.BLUE;

    private final GameMechanic gm;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        g2d.setColor(Color.GREEN);
        g2d.fillOval((int) gm.ballPosition().x(), (int) gm.ballPosition().y(), Constants.BALL_SIZE, Constants.BALL_SIZE);

        for (Target t : gm.targets()) {
            if (t.hit()) {
                g2d.setColor(HIT_TARGET_COLOR);
            } else {
                g2d.setColor(UNHIT_TARGET_COLOR);
            }
            g2d.fillOval((int) t.position().x(), (int) t.position().y(), Constants.TARGET_SIZE, Constants.TARGET_SIZE);
        }

        for (Charge c : gm.charges()) {
            if (c.getSign() > 0) {
                g2d.setColor(POSITIVE_COLOR);
            } else {
                g2d.setColor(NEGATIVE_COLOR);
            }
            g2d.fillOval((int) c.position().x(), (int) c.position().y(), Constants.CHARGE_SIZE, Constants.CHARGE_SIZE);
        }
    }

    public GamePanel(GameMechanic gm) {
        this.gm = gm;

        this.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Point p = getMousePosition();
                if (p != null) {
                    gm.onClick(new Vector2(p.x, p.y), e.getButton());
                }
            }
        });

        this.setBorder(new LineBorder(Color.BLACK, 5));
    }
}
