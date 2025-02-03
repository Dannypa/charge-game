package com.dannypa.ui;

import com.dannypa.logic.GameMechanic;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class SpeedControlPanel extends JPanel {
    final JLabel desc = new JLabel("Input speed and press enter: ");
    final TextField input = new TextField(15);
    final String LAUNCH_TEXT = "Launch!";
    final String RESET_TEXT = "Reset";
    final JButton launchAndReset = new JButton(LAUNCH_TEXT);

    private void configureUI(SpringLayout layout) {
        layout.putConstraint(SpringLayout.WEST, desc, 20, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, input, 5, SpringLayout.EAST, desc);
        layout.putConstraint(SpringLayout.WEST, launchAndReset, 10, SpringLayout.EAST, input);

        layout.putConstraint(SpringLayout.NORTH, input, 0, SpringLayout.NORTH, desc);
        layout.putConstraint(SpringLayout.SOUTH, input, 0, SpringLayout.SOUTH, desc);

        layout.putConstraint(SpringLayout.VERTICAL_CENTER, desc, 0, SpringLayout.VERTICAL_CENTER, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, launchAndReset, 0, SpringLayout.VERTICAL_CENTER, this);

    }

    public SpeedControlPanel(Font font, GameMechanic gm) {
        desc.setFont(font);
        input.setFont(font);
        launchAndReset.setFont(font);
        launchAndReset.addActionListener(e -> {
            if (Objects.equals(launchAndReset.getText(), LAUNCH_TEXT)) {
                launchAndReset.setText(RESET_TEXT);
                gm.onLaunch(Integer.parseInt(input.getText()));
            } else {
                launchAndReset.setText(LAUNCH_TEXT);
                gm.onLaunch(0);
            }
        });
        // TODO: Error message!

        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.add(desc);
        this.add(input);
        this.add(launchAndReset);

        configureUI(layout);
    }
}
