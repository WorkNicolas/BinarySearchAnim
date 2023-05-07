package mvc;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Thread;


public class Animation extends javax.swing.JPanel {
    private Model model;
    /**
     * From View, gets the value of int[] arr which is null
     * 
     * @param model
     */
    public Animation(Model model) {
        this.model = model;
        //setLayout(new java.awt.GridBagLayout());
    }
    /**
     * Paints array of boxes
     * 
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!(model.getArr() == null)) {
            for (int i = 0; i < model.getArr().length; i++) {
                paintElements(g, i, model.getArr()[i]);
                
            }
            for (int i = 0; i < model.getCounter(); i++) {
                paintIndex(g, i);
            }
        }
    }
    /**
     * Paints large green boxes with element values
     * 
     * @param g
     * @param index
     * @param element
     */
    private void paintElements(Graphics g, int index, int element) {
        // Outer Rectangle Properties
        int side = 75;
        int border = 10;
        int spacing = index * 100;
        int outerX = spacing + 20;
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
    private void paintIndex(Graphics g, int index) {
        // Outer Rectangle Properties
        int side = 50;
        int border = 10;
        int spacing = index * 100;
        int outerX = spacing + 30;
        int outerY = 90;

        // Inner Rectangle Properties
        int innerSide = side - 2 * border;
        int innerX = outerX + 10;
        int innerY = outerY + 10;

        // String Properties
        int fontSize = 15;
        
        // Outer Rectangle
        g.setColor(Color.RED);
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
        if (index >= 0 && index < 10) {
            g.drawString("" + index, innerX + innerSide/2 - 3, innerY + innerSide/2 + 7);
        } else if (index >= 10 && index < 100) {
            g.drawString("" + index, innerX + innerSide/2 - 8, innerY + innerSide/2 + 7);
        } else if (index >= 100 && index < 1000) {
            g.drawString("" + index, innerX + innerSide/2 - 21, innerY + innerSide/2 + 7);
        }
    }
    /**
     * For View architecture
     * 
     * @param model
     */
    public void setModel (Model model) {
        this.model = model;
    }
    /**
     * For View architecture
     * 
     * @return
     */
    public Model getModel() {
        return model;
    }
}
