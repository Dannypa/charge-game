package com.dannypa.ui;

import com.dannypa.Constants;
import com.dannypa.logic.GameMechanic;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GridBagConstraints getMainGBC(int gridy, double weighty) {
        return Utility.getGBC(0, gridy, 1, weighty, GridBagConstraints.BOTH);
    }

    private void addPanelToMainColumn(Component p, int gridy, double weighty) {
        this.add(p, getMainGBC(gridy, weighty));
    }

    public MainFrame(GameMechanic gm) {
        this.setTitle("Charge Game");
        this.setLayout(new GridBagLayout());

        GamePanel p = new GamePanel(gm);
        this.addPanelToMainColumn(p, 0, Constants.GAME_PANEL_WEIGHT);

        JPanel bottom = new ControlAndInfoPanel();
        this.addPanelToMainColumn(bottom, 1, Constants.BOTTOM_WEIGHT);

        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
