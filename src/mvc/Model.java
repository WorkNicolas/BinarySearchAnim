package mvc;
import methods.ArrayGen;
import methods.BinarySearch;

public class Model {
    private int[] arr, start, end, mid;
    private int target;
    private int counter = 0;
    private BinarySearch bs = new BinarySearch();
    public Model() {

    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    public void setStart(int[] start) {
        this.start = start;
    }
    public void setEnd(int[] end) {
        this.end = end;
    }
    public void setMid(int[] mid) {
        this.mid = mid;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setBs(BinarySearch bs) {
        this.bs = bs;
    }

    public int getCounter() {
        return counter;
    }
    public int[] getArr() {
        return arr;
    }
    public int[] getStart() {
        return start;
    }
    public int[] getEnd() {
        return end;
    }
    public int[] getMid() {
        return mid;
    }
    public int getTarget() {
        return target;
    }
    public BinarySearch getBs() {
        return bs;
    }
}
