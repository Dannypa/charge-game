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
import java.awt.event.MouseListener;

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
