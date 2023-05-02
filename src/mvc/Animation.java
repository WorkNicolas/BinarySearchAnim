package mvc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Animation extends javax.swing.JPanel {
    private Model model;
    public Animation(Model model) {
        this.model = model;
    }

    public void paint(Graphics g) {
        if (!(model.getArr() == null)) {
            for (int i = 0; i < model.getArr().length; i++) {
                paintElements(g, i, model.getArr()[i]);
            }
        } else { //for testing, remove later
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i * 2;
                paintElements(g, i, arr[i]);
            }
        }
    }

    private void paintElements(Graphics g, int index, int element) {
        // Outer Rectangle Properties
        int side = 75;
        int border = 10;
        index *= 100;
        int outerX = index + 20;
        int outerY = 150;

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
