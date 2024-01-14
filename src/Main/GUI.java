package Main;

import javax.swing.*;
import java.awt.*;


public abstract class GUI {
    private static final JFrame GUI = new JFrame();

    private static final JPanel MAIN_PANEL = new JPanel();
    private static final JPanel BOARD_PANEL = new JPanel();

    private static final Color LIGHT_COLOR = new Color(229, 211, 168);
    private static final Color DARK_COLOR = new Color(80, 80, 80);

    private static final String WHITE_PATH = "src\\PieceImages\\White";
    private static final String BLACK_PATH = "src\\PieceImages\\Black";

    private static JPanel[][] positions = new JPanel[8][8];


    public static void setup() {
        GUI.setName("Chess");
        GUI.setSize(1000, 1000);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setup Game Board
        BOARD_PANEL.setLayout(new GridLayout(8, 8));

        // Checker Board
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions[i][j] = new JPanel();
                if (count % 2 == 0) positions[i][j].setBackground(LIGHT_COLOR);
                else positions[i][j].setBackground(DARK_COLOR);
                BOARD_PANEL.add(positions[i][j]);
                count++;
            }
            count++;
        }

        MAIN_PANEL.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;

        MAIN_PANEL.add(BOARD_PANEL, c);
        GUI.add(MAIN_PANEL);
        GUI.setVisible(true);
    }
    

    public static void setPosition(boolean isWhite, String pieceName, int x, int y) {
        positions[x][y].removeAll(); // Remove any existing components from the panel
        String path = (isWhite) ? WHITE_PATH+"\\"+pieceName+".png" : BLACK_PATH+"\\"+pieceName+".png";
        ImageIcon image = new ImageIcon(path);
        positions[x][y].add(new JLabel(image));
        positions[x][y].revalidate(); // Force the layout manager to update the panel
        positions[x][y].repaint(); // Redraw the panel
    }
}
