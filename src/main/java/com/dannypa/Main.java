package com.dannypa;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


//class GamePanel extends JPanel {
//    public static int vm = 0;
//    Random r = new Random();
//    private final double ANGLE = r.nextInt(90) * Math.PI / 180;
//    public static final int TIMER_DELAY = 10;
//    private final int csz = 10;
//    private Vector2 p = new Vector2(10, 10);
//    private Vector2 v = new Vector2(vm * Math.cos(ANGLE), vm * Math.sin(ANGLE));
//    private boolean state = false;
//    private final double CK = 10;
//    int num_targets = 2;
//    int hit = 0;
//    private Vector2[] targets = new Vector2[num_targets];
//    private boolean[] active = new boolean[num_targets];
//    ArrayList<Charge> charges = new ArrayList<>();
//
//    GamePanel() {
//        for (int i = 0; i < num_targets; i++) {
//            targets[i] = new Vector2(r.nextInt(850) + 10, r.nextInt(450) + 10);
//            active[i] = true;
//        }
//    }
//
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.GREEN);
//        g2d.fillOval((int) p.x - csz, (int) p.y - csz, csz, csz);
//        for (int i = 0; i < num_targets; i++) {
//            if (active[i]) g2d.setColor(Color.BLACK);
//            else g2d.setColor(Color.CYAN);
//            g2d.fillOval((int) targets[i].x - csz, (int) targets[i].y - csz, csz, csz);
//        }
//        for (Charge c : charges) {
//            if (c.sign == 1) g2d.setColor(Color.BLUE);
//            else g2d.setColor(Color.RED);
//            g2d.fillOval((int) c.p.x - csz, (int) c.p.y - csz, csz, csz);
//        }
//    }
//
//    public void update() {
//        if (!state) return;
//        Vector2 a = new Vector2(0, 0);
//        for (Charge c : charges) {
//            Vector2 dir = c.p.sub(p);
//            if (dir.getSqLength() == 0) continue;
//            a = a.add(dir.scale(CK / (dir.getSqLength())));
//        }
//        v = v.add(a);
//        p = p.add(v);
//        for (int i = 0; i < num_targets; i++) {
//            if (targets[i].sub(p).getSqLength() <= 4 * csz * csz && active[i]) {
//                System.out.println("-1!!!!");
//                hit++;
//                active[i] = false;
//                if (hit == num_targets) {
//                    System.out.println("WIN!");
//                    System.exit(0);
//                }
//                System.out.println("Only " + (num_targets - hit) + " left!");
//            }
//        }
//    }
//
//    public void onPress(int v_new) {
//        state = !state;
//        vm = v_new;
//        p = new Vector2(10, 10);
//        v = new Vector2(vm * Math.cos(ANGLE), vm * Math.sin(ANGLE));
//        for (int i = 0; i < num_targets; i++) active[i] = true;
//        hit = 0;
//    }
//
//    public void onClick(int sign) {
//        if (getMousePosition() != null) {
//            charges.add(new Charge(new Vector2(getMousePosition().getX(), getMousePosition().getY()), sign));
//        }
//    }
//}
//
//
//public class Main {
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Aboba");
//        GamePanel p = new GamePanel();
//        frame.add(p);
//        frame.setSize(500, 500);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        Timer t = new Timer(GamePanel.TIMER_DELAY, (a) -> {
//            p.update();
//            frame.repaint();
//        });
//        t.start();
//
//
//        p.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                p.onClick(e.getButton() - 2);
//                p.repaint();
//            }
//        });
//
//
//        JPanel box = new JPanel();
//        frame.getContentPane().add(box, BorderLayout.EAST);
//        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
//        JTextField tf = new JTextField();
//        box.add(tf);
//        box.add(Box.createVerticalStrut(1000));
//        box.add(new JButton("ТЕКСТ"));
//        frame.resize(1000, 500);
//        tf.addActionListener((te) -> {
//            p.onPress(Integer.parseInt(tf.getText()));
//        });
//    }
//}


class GamePanel extends JPanel {
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

class Utility {
    public static GridBagConstraints getGBC(
            int gridx,
            int gridy,
            double weightx,
            double weighty,
            int fill
    ) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.fill = fill;
        return gbc;
    }
}


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


class ControlAndInfoPanel extends JPanel {
    private final double[] VERTICAL_WEIGHTS = new double[]{1, 1, 1};

    private final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 25);

    private final JLabel INFO = new JLabel("Attempts: 0");


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

    public ControlAndInfoPanel() {
        this.setLayout(new GridBagLayout());

        JPanel controls = new SpeedControlPanel(FONT);
        JPanel stats = getStatPanel();

        addFillerRow(0, VERTICAL_WEIGHTS[0]);

        this.add(controls, Utility.getGBC(
                0, 1, 1, VERTICAL_WEIGHTS[1], GridBagConstraints.BOTH
        ));

        this.add(stats, Utility.getGBC(
                1, 1, 1, VERTICAL_WEIGHTS[1], GridBagConstraints.BOTH
        ));

        this.addFillerRow(2, VERTICAL_WEIGHTS[2]);
    }
}


class MainFrame extends JFrame {
    private final int GAME_PANEL_Y = 0;
    private final double GAME_PANEL_WEIGHT = 5;
    private final int BOTTOM_Y = 1;
    private final double BOTTOM_WEIGHT = 1;

    private GridBagConstraints getMainGBC(
            int gridy,
            double weighty
    ) {
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

public class Main {
    public static void main(String[] args) {
        new MainFrame();
    }
}