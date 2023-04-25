package arch;
import java.util.Random;
import java.util.Arrays;

public class BinarySearch {
    private int[] arr;

    private int[] generateArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);
        }
        Arrays.sort(arr);
        return arr;
    }
}
