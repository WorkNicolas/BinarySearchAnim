/**
 * Tracks model and view changes
 * 
 * @author WorkNicolas
 * @version 2023-04-25
 */
package mvc;

public class Controller {
    private Model model;
    private View view;
    /**
     * Acquires changes from model and view
     * 
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.updateView();
    }
    public void updateView() {
        view.updateView();
    }
    
}
