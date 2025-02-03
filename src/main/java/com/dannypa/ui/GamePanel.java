package com.dannypa.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillOval(0, 0, 10, 10);
    }

    public GamePanel() {
        super();
        this.setBorder(new LineBorder(Color.RED, 5));
    }
}
