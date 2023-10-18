import mpp.dynamicarray.DynamicArray;
import mpp.dynamicarray.DynamicArrayImpl;

public class Main {
    public static void main(String[] args) {
        DynamicArrayImpl<Integer> arr = new DynamicArrayImpl<>();
        arr.pushBack(5);
        System.out.println(arr.getSize());
    }
}
