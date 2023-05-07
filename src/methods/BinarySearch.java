package methods;

import mvc.Model;

public class BinarySearch
{
    private int[] arr;
    private int middle, nextStart, nextEnd;
    private Model model;

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
    
    public void findTarget(int target, int start, int end, Model model)
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
            findTarget(target, start, middle-1, model);
        }

        if (arr[middle] < target) {
            findTarget(target, middle+1, end, model);
        }
    }
}
