package arch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    int[] arr;
    View view = new View();
    public Controller(View view) {
        this.view = view;

        this.view.addBtnListener(new );
    }
    class BtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                arr = view.getArray();
            } catch (NumberFormatException ex) {
                System.out.println(e);
            }
        }
    }
}
