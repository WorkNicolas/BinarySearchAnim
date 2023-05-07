/**
 * MVC View architecture that handles what the user sees
 * 
 * @author WorkNicolas
 * @version 2023-04-26
 */
package mvc;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import methods.ArrayGen;
import methods.BinarySearch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    private Model model = new Model();
    private JFrame frame = new JFrame();
    private JPanel upanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //upper panel
    private Animation lpanel = new Animation(model); //lower panel
    private JButton btn = new JButton("Array Size");
    private JTextField tf = new JTextField();
    private JLabel lb = new JLabel(); // array
    private JLabel mv = new JLabel(); // middle value
    private JLabel tv = new JLabel(); // target value
    private JLabel mi = new JLabel(); // middle index
    private JLabel mc = new JLabel(); // middle calculation
    
    /**
     * Generates the menu
     * 
     * @param model
     */
    public View(Model model) {
        this.model = model;

        //grid
        frame.setLayout(new GridBagLayout());

        //panel borders
        upanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createLineBorder(Color.BLACK)));

        //panel size
        final int PANEL_WIDTH = 800, PANEL_HEIGHT = 600;
        upanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT - 530));
        lpanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT - 70));

        //textfield width
        tf.setColumns(4);

        //panel settings
        upanel.add(btn);
        upanel.add(tf);
        lpanel.add(lb);

        //frame settings
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.2;
        frame.add(upanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.8;
        frame.add(lpanel, gbc);

        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); //frame size is based on panel size
        frame.setVisible(true);

        //Listener
        btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            try {
                // Create a random array based on textfield
                model.setArr(
                    new ArrayGen().generateArray(
                        Integer.valueOf(
                            tf.getText()
                            )
                    )
                );

                /**
                 * Set target value based on array element
                 * whose index is randomly chosen based on
                 * the length of the array
                 * 
                 */
                model.setTarget(
                    model.getArr()
                        [new ArrayGen().selectRandom(
                            model.getArr().length
                            )
                        ]
                    );
                calculateBs();
                updateView();
            } catch(NumberFormatException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, ex, "Invalid Number Format", JOptionPane.ERROR_MESSAGE);
            } catch(NegativeArraySizeException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, ex, "Negative Array Size", JOptionPane.ERROR_MESSAGE);
            } 
           } 
        });
    }
    
    /**
     * Updates JLabel lb and Animation class
     */
    public void updateView() {
        lb.setText("Array: " + Arrays.toString(model.getArr()));
        
        forwardIndex();
    }
    public void calculateBs() {
        // Set up a model's binary search
        model.setBs(new BinarySearch(model.getArr()));
        /**
         * Find the target to get the array
         * of middle values, start values,
         * and end values
         * 
         */
        model.getBs().findTarget(
            model.getTarget(),
            0,
            model.getArr().length,
            0
            );

        /**
         * Get start, end and middle values
         * from BinarySearch()
         * 
         */
        model.setStart(model.getBs().getStart());
        model.setEnd(model.getBs().getEnd());
        model.setMid(model.getBs().getMiddle());
    }
    public void forwardIndex() {
        if (model.getArr() != null) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                int counter = 0;
                public void run() {
                    btn.setEnabled(false);
                    if (model.getArr() == null) {
                        btn.setEnabled(true);
                    }
                    model.setCounter(counter);
                    ++counter;
                    lpanel.setModel(model);
                    frame.revalidate();
                    frame.repaint();
                    /**
                     * Gives NullPointerException in the terminal
                     * This is why the condition is set to only run
                     * when model.getArr() != null.
                     *
                     * When ignored with try/catch, an array of boxes
                     * will appear and disappear.
                     *
                     * For some reason forwardIndex() runs w/o any
                     * prompt, the error can be ignored but, I don't
                     * like seeing errors so, I managed the problem
                     * here.
                     *
                     */
                    if (counter >= model.getArr().length + 1) {
                        timer.cancel();
                        btn.setEnabled(true);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                        reverseIndex();
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 0, 200);
        }
    }
    public void reverseIndex() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int counter = model.getArr().length;
            public void run() {
                btn.setEnabled(false);
                if (model.getArr() == null) {
                    btn.setEnabled(true);
                }
                model.setCounter(counter);
                --counter;
                lpanel.setModel(model);
                frame.revalidate();
                frame.repaint();
                if (counter <= -1) {
                    timer.cancel();
                    btn.setEnabled(true);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 200);
    }
    /**
     * For Controller architecture
     * 
     * @param model
     */
    public void setModel(Model model) {
        this.model = model;
    }
    /**
     * For Controller architecture
     * 
     * @return
     */
    public Model getModel() {
        return model;
    }
}
