package com.dannypa.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final int GAME_PANEL_Y = 0;
    private final double GAME_PANEL_WEIGHT = 5;
    private final int BOTTOM_Y = 1;
    private final double BOTTOM_WEIGHT = 1;

    private GridBagConstraints getMainGBC(int gridy, double weighty) {
        return Utility.getGBC(0, gridy, 1, weighty, GridBagConstraints.BOTH);
    }

    private void addPanelToMainColumn(Component p, int gridy, double weighty) {
        this.add(p, getMainGBC(gridy, weighty));
    }

    public MainFrame() {
        this.setTitle("Charge Game");
        this.setLayout(new GridBagLayout());

        GamePanel p = new GamePanel();
        this.addPanelToMainColumn(p, GAME_PANEL_Y, GAME_PANEL_WEIGHT);

        JPanel bottom = new ControlAndInfoPanel();
        this.addPanelToMainColumn(bottom, BOTTOM_Y, BOTTOM_WEIGHT);

        this.setSize(1920, 1080);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
