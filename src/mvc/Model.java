package mvc;
import methods.ArrayGen;

public class Model {
    private int[] arr;
    private int counter = 0;
    public Model() {

    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getCounter() {
        return counter;
    }
    public int[] getArr() {
        return arr;
    }
}
