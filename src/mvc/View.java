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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class View {
    private Model model = new Model();
    private JFrame frame = new JFrame();
    private JPanel upanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); //upper panel
    private Animation lpanel = new Animation(model); //lower panel
    private JPanel iPanel = new JPanel(new GridBagLayout());
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
        lpanel.add(iPanel, BorderLayout.SOUTH);
        GridBagConstraints pgbc = new GridBagConstraints();
        pgbc.gridx = 0;
        pgbc.gridy = 0;
        pgbc.insets = new Insets(20,60,20,60);
        pgbc.anchor = GridBagConstraints.LAST_LINE_START;
        iPanel.add(mv, pgbc);
        pgbc.gridx = 1;
        pgbc.gridy = 0;
        iPanel.add(tv, pgbc);
        pgbc.gridx = 0;
        pgbc.gridy = 1;
        iPanel.add(mi, pgbc);
        pgbc.gridx = 1;
        pgbc.gridy = 1;
        iPanel.add(mc, pgbc);
        pgbc.gridx = 0;
        pgbc.gridy = 2;
        iPanel.add(lb, pgbc);

        //frame settings
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.gridx = 0;
        fgbc.gridy = 0;
        fgbc.weighty = 0.2;
        frame.add(upanel, fgbc);

        fgbc.gridy = 1;
        fgbc.weighty = 0.8;
        frame.add(lpanel, fgbc);

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
                model.setTarget(model.getArr()[new ArrayGen().selectRandom(model.getArr().length)]);
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
        mv.setText("Middle Value: NaN");
        tv.setText("Target Value: NaN");
        mi.setText("Middle Index: NaN");
        mc.setText("Middle = (start + end)/2");

        // Animation
        int iterator = 0;
        model.setItr(iterator);
        System.out.println("Iterator: " + iterator);
        model.setIndexAnim(true);
        /**
         * NullPointerException
         *
         */
        if (model.getMid() != null) {
            forwardIndex(model.getMid()[iterator]);
        }
        /**
         * View.java completed arrays
         *
         */
        System.out.println("View.java");
        System.out.println("Iterator: " + iterator);
        System.out.println("Start: " + Arrays.toString(model.getStart()));
        System.out.println("End: " + Arrays.toString(model.getEnd()));
        System.out.println("Middle: " + Arrays.toString(model.getMid()));
        System.out.println("Runs: " + model.getRuns());
    }
    public void newText(int count) {
        mv.setText("Middle Value: " + model.getArr()[count]);
        tv.setText("Target Value: " + model.getTarget());
        mi.setText("Middle Index: " + count);
        if (count == 0) {
            mc.setText("Middle = " + "(" + 0 + " + " + (model.getArr().length - 1) + ")" + "/2");
        } else if (count == model.getArr().length - 1) {
            mc.setText("Middle = " + "(" + (model.getArr().length - 1) + " + " + (model.getArr().length - 1) + ")" + "/2");
        } else if (count == model.getArr().length - 2) {
            mc.setText("Middle = " + "(" + (model.getArr().length - 2) + " + " + (model.getArr().length - 1) + ")" + "/2");
        } else {
            mc.setText("Middle = " + "(" + model.getStart()[count] + " + " + model.getEnd()[count] + ")" + "/2");
        }

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
            model.getArr().length
            );

        /**
         * Get start, end and middle values
         * from BinarySearch()
         *
         */
        model.setStart(model.getBs().getStart());
        model.setEnd(model.getBs().getEnd());
        model.setMiddle(model.getBs().getMiddle());
        model.setRuns(model.getBs().getCount());
    }

    /**
     * Index boxes appears from left-to-right
     *
     */
    public void forwardIndex(int count) {
        if (model.getArr() != null && model.getIndexAnim()) {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            Runnable task = new Runnable() {
                int counter = 0;
                public void run() {
                    // button availability
                    btn.setEnabled(false);
                    if (model.getArr() == null) {
                        btn.setEnabled(true);
                    }
                    // iterate up for elements and index
                    model.setCounter(counter);
                    ++counter;
                    model.setItr(count);
                    lpanel.setModel(model);
                    frame.revalidate();
                    frame.repaint();
                    newText(count);
                    if (counter >= count + 1) {
                        delayTime(2);
                        executor.shutdown();
                        System.out.println("Iterator: " + model.getItr());
                        model.setIndexAnim(false);
                        reverseIndex(model.getMid()[model.getItr()]);
                    }
                }
            };
            executor.scheduleAtFixedRate(task, 0, 200, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Index disappears from right-to-left
     *
     */
    public void reverseIndex(int count) {
        if (!model.getIndexAnim()) {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            System.out.println("Current Counter Index: " + model.getMid()[model.getItr()]);
            Runnable task = new Runnable() {
                int counter = model.getMid()[model.getItr()] + 1;
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
                    if (counter <= -2) {
                        delayTime(2);
                        System.out.println("Run: " + count);
                        executor.shutdown();
                        if (model.getArr()[model.getItr()] == model.getTarget()) {
                            btn.setEnabled(true);
                            JOptionPane.showMessageDialog(null, model.getTarget() + " has been found!", "Target", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            model.setIndexAnim(true);
                            try {
                                System.out.println("model.getMid()[model.getItr() + 1] " + model.getMid()[model.getItr() + 1] );
                                forwardIndex(model.getMid()[model.getItr() + 1]);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                mc.setText("Middle = " + "(" + model.getArr().length + " - " + (model.getArr().length - 2) + ")/2");
                                forwardIndex(model.getArr().length - 2);
                            }
                        }
                    }
                }
            };
            executor.scheduleAtFixedRate(task, 200, 200, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Delay time according to the arumgne of
     * TimeUnit.SECONDS.sleep
     *
     */
    public void delayTime(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
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
