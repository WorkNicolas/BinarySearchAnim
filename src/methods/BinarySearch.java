package methods;

import mvc.Model;

import java.util.Arrays;

public class BinarySearch
{
    /**
     * Array of random values
     * Array of middle values used
     * Array of start values used
     * Array of end values used
     *
     */
    private int[] arr;
    private int[] startArr;
    private int[] middleArr;
    private int[] endArr;
    private int count;

    /**
     * All lengths and the array itself is acquired
     * from the constructor.
     *
     * @param arr
     */
    public BinarySearch(int[] arr) {
        this.arr = arr;
        this.startArr = new int[arr.length];
        this.middleArr = new int[arr.length];
        this.endArr = new int[arr.length];
        this.count = 0;
    }
    
    /**
     * Perform binary search algorithm
     * 
     * @param target element to search for
     * @param start where the binary search will start
     * @param end where the binary search will stop
     * @param itr number of iterations occured
     */
    public void findTarget(int target, int start, int end)
    {
        if (start > end)
        {
            System.out.print(target + " not found.");
        }
        int middle = (int) (start + end) / 2;
        if (arr[middle] == target) {
            startArr[count] = start;
            middleArr[count] = middle;
            endArr[count] = end;
            count++;
            System.out.println("BinarySearch.java");
            System.out.println("Start: " + Arrays.toString(startArr));
            System.out.println("End: " + Arrays.toString(endArr));
            System.out.println("Middle: " + Arrays.toString(middleArr));
            System.out.println("Runs: " + count);
            System.out.println(target + " found at index " + middle);
        }

        if (arr[middle] > target) {
            startArr[count] = start;
            middleArr[count] = middle;
            endArr[count] = middle - 1;
            count++;
            findTarget(target, start, middle-1);
        }

        if (arr[middle] < target) {
            startArr[count] = middle + 1;
            middleArr[count] = middle;
            endArr[count] = end;
            count++;
            findTarget(target, middle+1, end);
        }
    }

    // getter methods for start, middle, and end arrays and count
    public int[] getStart() {
        return startArr;
    }

    public int[] getMiddle() {
        return middleArr;
    }

    public int[] getEnd() {
        return endArr;
    }

    public int getCount() {
        return count;
    }
}
