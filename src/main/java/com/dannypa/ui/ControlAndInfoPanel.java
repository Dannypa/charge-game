package com.dannypa.ui;

import com.dannypa.logic.GameMechanic;

import javax.swing.*;
import java.awt.*;

public class ControlAndInfoPanel extends JPanel {
    private final double[] VERTICAL_WEIGHTS = new double[]{1, 1, 1};

    private final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 25);

    private final String INFO_TEXT = "Attempts: ";
    private final JLabel INFO = new JLabel(INFO_TEXT + 0);

    private final GameMechanic gm;


    private JPanel getStatPanel() {
        SpringLayout layout = new SpringLayout();
        JPanel stats = new JPanel(layout);
        INFO.setFont(FONT);
        stats.add(INFO);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, INFO, 0, SpringLayout.VERTICAL_CENTER, stats);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, INFO, 0, SpringLayout.HORIZONTAL_CENTER, stats);
        return stats;
    }

    private void addFillerRow(int gridy, double weighty) {
        this.add(Box.createVerticalGlue(), Utility.getGBC(0, gridy, 1, weighty, GridBagConstraints.BOTH));
    }

    public void updateInfo() {
        INFO.setText(INFO_TEXT + gm.attemptCounter());
    }

    public ControlAndInfoPanel(GameMechanic gm) {
        this.setLayout(new GridBagLayout());

        this.gm = gm;
        JPanel controls = new SpeedControlPanel(FONT, gm);
        JPanel stats = getStatPanel();

        addFillerRow(0, VERTICAL_WEIGHTS[0]);

        this.add(controls, Utility.getGBC(0, 1, 1, VERTICAL_WEIGHTS[1], GridBagConstraints.BOTH));

        this.add(stats, Utility.getGBC(1, 1, 1, VERTICAL_WEIGHTS[1], GridBagConstraints.BOTH));

        this.addFillerRow(2, VERTICAL_WEIGHTS[2]);
    }
}
