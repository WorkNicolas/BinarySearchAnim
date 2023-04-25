package arch;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import arch.models.ArrayGen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame = new JFrame();
    private JPanel upanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //upper panel
    private JPanel lpanel = new JPanel(); //lower panel
    private JButton btn = new JButton("Array Size");
    private JTextField tf = new JTextField();

    public void genericMenu() {
        

        //grid
        frame.setLayout(new GridBagLayout());

        //panel borders
        upanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createLineBorder(Color.BLACK)));
        lpanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createLineBorder(Color.BLACK)));

        //panel size
        int panelWidth = 800, panelHeight = 600;
        upanel.setPreferredSize(new Dimension(panelWidth, panelHeight - 530));
        lpanel.setPreferredSize(new Dimension(panelWidth, panelHeight - 70));

        //textfield width
        tf.setColumns(4);

        //panel settings
        upanel.add(btn);
        upanel.add(tf);

        //frame settings
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.2;
        frame.add(upanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.8;
        frame.add(lpanel, gbc);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public int[] getArray() {
        int[] arr = null;
        try {
            arr = new ArrayGen().generateArray(Integer.valueOf(tf.getText()));
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Invalid input", "Warning", JOptionPane.ERROR_MESSAGE);
        }
        return arr;
    }

    void addBtnListener(ActionListener listenBtn) {
        btn.addActionListener(listenBtn);
    }
}
