package methods;
import java.util.Random;
import java.util.Arrays;

public class ArrayGen {
    /**
     * Generates an array with randomized elements
     * 
     * @param size Array length
     * @return
     */
    public int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(999);
        }
        Arrays.sort(arr);
        return arr;
    }
    /**
     * Chooses a random target based on array length
     * 
     * @param length
     * @return
     */
    public int selectRandom(int length) {
        int target = new Random().nextInt(length);
        return target;
    }
}
