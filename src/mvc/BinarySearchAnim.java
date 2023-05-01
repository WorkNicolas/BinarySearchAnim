/**
 * Handles animation
 * 
 * @author WorkNicolas
 * @version 2023-04-25
 */
package mvc;

public class BinarySearchAnim {
    private Model model;
    private View view;
    private Controller ctrl;
    
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
        
    }
}
