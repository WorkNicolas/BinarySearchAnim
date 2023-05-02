package mvc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Animation extends javax.swing.JPanel {
    public Animation() {
        
    }

    public void paint(Graphics g) {
        paintElements(g, 20, 100);
    }

    public void paintElements(Graphics g, int index, int element) {
        // Outer Rectangle Properties
        int side = 75;
        int border = 10;
        int outerX = index + 5;
        int outerY = index + 150;

        // Inner Rectangle Properties
        int innerSide = side - 2 * border;
        int innerX = outerX + 10;
        int innerY = outerY + 10;

        // String Properties
        int fontSize = 30;
        

        // Outer Rectangle
        g.setColor(Color.GREEN);
        g.fillRect(outerX, outerY, side, side);
        g.setColor(Color.BLACK);
        g.drawRect(outerX, outerY, side, side);

        // Inner Rectangle
        g.setColor(Color.WHITE);
        g.fillRect(innerX, innerY, innerSide, innerSide);
        g.setColor(Color.BLACK);
        g.drawRect(innerX, innerY, innerSide, innerSide);

        // String
        g.setFont(new Font("Arial", Font.BOLD, fontSize));
        if (element >= 0 && element < 10) {
            g.drawString("" + element, innerX + innerSide/2 - 7, innerY + innerSide/2 + 12);
        } else if (element >= 10 && element < 100) {
            g.drawString("" + element, innerX + innerSide/2 - 15, innerY + innerSide/2 + 12);
        } else if (element >= 100 && element < 1000) {
            g.drawString("" + element, innerX + innerSide/2 - 25, innerY + innerSide/2 + 12);
        }
    }
}
