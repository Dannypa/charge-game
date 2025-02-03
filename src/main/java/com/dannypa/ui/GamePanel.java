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

    private final Color BALL_COLOR = Color.GREEN;

    private final Color BACKGROUND_WIN_COLOR = new Color(3, 79, 32);
    private final Color WIN_COLOR = Color.WHITE;
    private final Font WIN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 80);
    private final String WIN_STRING = "You win!!!";

    private final GameMechanic gm;

    private void drawBall(Graphics2D g2d) {
        g2d.setColor(BALL_COLOR);
        g2d.fillOval((int) gm.ballPosition().x(), (int) gm.ballPosition().y(), Constants.BALL_SIZE, Constants.BALL_SIZE);
    }

    private void drawTargets(Graphics2D g2d) {
        for (Target t : gm.targets()) {
            if (t.hit()) {
                g2d.setColor(HIT_TARGET_COLOR);
            } else {
                g2d.setColor(UNHIT_TARGET_COLOR);
            }
            g2d.fillOval((int) t.position().x(), (int) t.position().y(), Constants.TARGET_SIZE, Constants.TARGET_SIZE);
        }
    }

    private void drawCharges(Graphics2D g2d) {
        for (Charge c : gm.charges()) {
            if (c.getSign() > 0) {
                g2d.setColor(POSITIVE_COLOR);
            } else {
                g2d.setColor(NEGATIVE_COLOR);
            }
            g2d.fillOval((int) c.position().x(), (int) c.position().y(), Constants.CHARGE_SIZE, Constants.CHARGE_SIZE);
        }
    }

    private void drawWinScreen(Graphics2D g2d) {
        g2d.setFont(WIN_FONT);

        FontMetrics fm = g2d.getFontMetrics();
        int stringWidth = fm.stringWidth(WIN_STRING);
        int x = (getWidth() - stringWidth) / 2;
        int stringHeight = fm.getHeight();
        int y = (getHeight() - stringHeight) / 2;

        g2d.setColor(BACKGROUND_WIN_COLOR);
        g2d.fillRect(
                x - Constants.WIN_BACKGROUND_OFFSET,
                y - stringHeight + Constants.WIN_BACKGROUND_OFFSET,
                stringWidth + 2 * Constants.WIN_BACKGROUND_OFFSET, stringHeight
        );
        g2d.setColor(WIN_COLOR);
        g2d.drawString(WIN_STRING, x, y);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);

        drawBall(g2d);
        drawTargets(g2d);
        drawCharges(g2d);

        if (gm.isWon()) {
            drawWinScreen(g2d);
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
    }
}
