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
        model = view.getModel();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
    
}
