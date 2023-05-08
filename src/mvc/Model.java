package mvc;

public class Model {
    // run BinarySearch.java first then get an array of values
    private int[] arr, start, end, mid;
    private int target;
    // iterate through Animation.java index
    private int counter;
    // number of BinarySearch.java runs before finding target
    private int runs;
    // iterate through int[] mid
    private int itr;
    private int indexAnim;
    private methods.BinarySearch bs;
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
    public void setMiddle(int[] mid) {
        this.mid = mid;
    }
    public void setTarget(int target) {
        this.target = target;
    }
    public void setBs(methods.BinarySearch bs) {
        this.bs = bs;
    }
    public void setRuns(int runs) {
        this.runs = runs;
    }
    public void setItr(int itr) {
        this.itr = itr;
    }
    public void setIndexAnim(int indexAnim) {
        this.indexAnim = indexAnim;
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
    public methods.BinarySearch getBs() {
        return bs;
    }
    public int getRuns() {
        return runs;
    }
    public int getItr() {
        return itr;
    }
    public int getIndexAnim() {
        return indexAnim;
    }
}
