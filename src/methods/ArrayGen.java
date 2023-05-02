package methods;
import java.util.Random;
import java.util.Arrays;

public class ArrayGen {

    public int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(999);
        }
        Arrays.sort(arr);
        return arr;
    }
}
