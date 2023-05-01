/**
 * Handles animation
 * 
 * @author WorkNicolas
 * @version 2023-04-25
 */
package mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BinarySearchAnim {
    private Model model;
    private View view;
    private Controller ctrl;

    private JPanel panel = new JPanel();
    
    /**
     * MVC arguments are used to ensure bidirectional data
     * 
     * @param model Model architecture
     * @param view View Architecture
     * @param ctrl Controller Architecture
     */
    public BinarySearchAnim (Model model, View view, Controller ctrl) {
        this.model = model;
        this.view = view;
        this.ctrl = ctrl;
        int[] arr = ctrl.getModel().getArr();

    }
    /**
     * Creates boxes with numbers
     * 
     */
    public class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int side = 200;
            int border = 10;
            int innerSide = side - 2 * border;
            int innerX = border;
            int innerY = border;
            int number = 5;
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, side, side);
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, side, side);
            g.setColor(Color.WHITE);
            g.fillRect(innerX, innerY, innerSide, innerSide);
            g.setColor(Color.BLACK);
            g.drawRect(innerX, innerY, innerSide, innerSide);
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.drawString("" + number, innerX + innerSide/2 - 25, innerY + innerSide/2 + 25);
        }
    }
}
