package com.dannypa.ui;

import com.dannypa.logic.GameMechanic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class SpeedControlPanel extends JPanel {
    final JLabel desc = new JLabel("Input speed and press enter: ");
    final TextField input = new TextField(15);
    final JButton launch = new JButton("Launch!");

    private void configureUI(SpringLayout layout) {
        layout.putConstraint(SpringLayout.WEST, desc, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, input, 5, SpringLayout.EAST, desc);
        layout.putConstraint(SpringLayout.WEST, launch, 10, SpringLayout.EAST, input);

        layout.putConstraint(SpringLayout.NORTH, input, 0, SpringLayout.NORTH, desc);
        layout.putConstraint(SpringLayout.SOUTH, input, 0, SpringLayout.SOUTH, desc);

        layout.putConstraint(SpringLayout.VERTICAL_CENTER, desc, 0, SpringLayout.VERTICAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, launch, 0, SpringLayout.VERTICAL_CENTER, this);

    }

    public SpeedControlPanel(Font font, GameMechanic gm) {
        desc.setFont(font);
        input.setFont(font);
        launch.setFont(font);
        launch.addActionListener(e -> gm.onLaunch(Integer.parseInt(input.getText())));
        // TODO: Error message!

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.add(desc);
        this.add(input);
        this.add(launch);

        configureUI(layout);
    }
}
