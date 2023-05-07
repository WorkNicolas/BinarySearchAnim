package methods;

import mvc.Model;

public class BinarySearch
{
    /**
     * Array of random values
     * Array of middle values used
     * Array of start values used
     * Array of end values used
     *
     */
    private int[] arr, mid, nextStart, nextEnd;

    /**
     * All lengths and the array itself is acquired
     * from the constructor.
     *
     * @param arr
     */
    public BinarySearch(int[] arr) {
        this.arr = arr;
        this.nextStart = new int[arr.length];
        this.nextEnd = new int[arr.length];
        this.mid = new int[arr.length];
    }
    public void setArr(int[] arr) {
        this.arr =arr;
    }

    public int[] getArr() {
        return arr;
    }
    public int[] getMiddle() {
        return mid;
    }
    public int[] getStart() {
        return nextStart;
    }
    public int[] getEnd() {
        return nextEnd;
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
    public void findTarget(int target, int start, int end, int itr)
    {
        if (start > end)
        {
            System.out.print(target + " not found.");
        }
        int middle = (int) (start + end) / 2;
        if (arr[middle] == target) {
            System.out.println(target + " found at index " + middle);
        }

        if (arr[middle] > target) {
            nextStart[itr] = start;
            nextEnd[itr] = middle - 1;
            itr++;
            findTarget(target, start, middle-1, itr);
        }

        if (arr[middle] < target) {
            nextStart[itr] = middle - 1;
            nextEnd[itr] = end;
            itr++;
            findTarget(target, middle+1, end, itr);
        }
    }
}
