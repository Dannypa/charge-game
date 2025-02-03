package com.dannypa.ui;

import java.awt.*;

public class Utility {
    public static GridBagConstraints getGBC(int gridx, int gridy, double weightx, double weighty, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = fill;
        return gbc;
    }
}
