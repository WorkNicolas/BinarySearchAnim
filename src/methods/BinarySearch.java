package methods;

import mvc.Model;

public class BinarySearch
{
    private int[] arr;
    private int middle, nextStart, nextEnd;
    private Model model;

    public BinarySearch(Model model) {
        this.model = model;
    }
    
    public int getMiddle() {
        return middle;
    }
    public int getStart() {
        return nextStart;
    }
    public int getEnd() {
        return nextEnd;
    }
    public Model getModel() {
        return model;
    }
    
    /**
     * Perform binary search algorithm
     * 
     * @param target element to search for
     * @param start where the binary search will start
     * @param end where the binary search will stop
     * @param model to return the model and inherit start, end, and middle
     * @param itr number of iterations occured
     */
    public void findTarget(int target, int start, int end, Model model, int itr)
    {
        if (start > end)
        {
            System.out.print(target + " not found.");
        }
        middle = (int) (start + end) / 2;

        if (arr[middle] == target) {
            System.out.println(target + " found at index " + middle);
        }

        if (arr[middle] > target) {
            nextStart = start;
            nextEnd = middle - 1;
            findTarget(target, start, middle-1, model, itr);
        }

        if (arr[middle] < target) {
            findTarget(target, middle+1, end, model, itr);
        }
    }
}
