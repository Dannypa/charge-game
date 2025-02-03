package com.dannypa.ui;

import javax.swing.*;
import java.awt.*;

class SpeedControlPanel extends JPanel {
    final JLabel desc = new JLabel("Input speed and press enter: ");
    final TextField input = new TextField(15);

    private void configureUI(SpringLayout layout) {
        layout.putConstraint(SpringLayout.WEST, desc, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, input, 5, SpringLayout.EAST, desc);
        layout.putConstraint(SpringLayout.NORTH, input, 0, SpringLayout.NORTH, desc);
        layout.putConstraint(SpringLayout.SOUTH, input, 0, SpringLayout.SOUTH, desc);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, desc, 0, SpringLayout.VERTICAL_CENTER, this);

    }

    public SpeedControlPanel(Font font) {
        desc.setFont(font);
        input.setFont(font);

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.add(desc);
        this.add(input);

        configureUI(layout);
    }
}
