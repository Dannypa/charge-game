package com.dannypa;

import com.dannypa.logic.GameMechanic;
import com.dannypa.ui.MainFrame;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        int gamePanelWidth = Constants.SCREEN_WIDTH;
        int gamePanelHeight = (Constants.SCREEN_HEIGHT *
                Constants.GAME_PANEL_WEIGHT) / (Constants.GAME_PANEL_WEIGHT + Constants.BOTTOM_WEIGHT);
        System.out.println(gamePanelHeight);
        System.out.println(Constants.SCREEN_HEIGHT);
        GameMechanic gm = new GameMechanic(
                gamePanelWidth,
                gamePanelHeight,
                2 * Collections.max(Arrays.asList(Constants.BALL_SIZE, Constants.TARGET_SIZE, Constants.CHARGE_SIZE)),
                Constants.BALL_OFFSET
        );

        JFrame frame = new MainFrame(gm);

        Timer t = new Timer((int) (GameMechanic.DT * 1000), e -> {
            gm.update();
            frame.repaint();
        });
        t.start();

    }
}