package arch.methods;

import java.lang.Math;
import java.util.Scanner;

public class BinarySearch
{
    int[] arr;
    public void findTarget(int target, int start, int end)
    {
        if (start > end)
        {
            System.out.print(target + " not found.");
        }
        int middle = (int) Math.floor((start + end) / 2);

        if (arr[middle] == target) {
            System.out.println(target + " found at index " + middle);
        }

        if (arr[middle] > target) {
            findTarget(target, start, middle-1);
        }

        if (arr[middle] < target) {
            findTarget(target, middle+1, end);
        }
    }
}
