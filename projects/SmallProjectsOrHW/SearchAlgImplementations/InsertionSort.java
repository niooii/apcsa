package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.Arrays;

import static SmallProjectsOrHW.LinearAndBinarySearch.LinearAndBinarySearch.reset;

public class InsertionSort {
    static int[] array = new CollectionInitializer(10, "array").getArray();
    public static void main(String[] args){
        System.out.println(Arrays.toString(array));

    }
    public static void InsertionSort() {

    }

    public static void insert(int[] array, int maxIndex, int element) {
        boolean condition1 = false, condition2 = false;
        for(int i = 0; i < maxIndex; i++){
            if(condition1 && condition2){
                array[i] = element;
                break;
            }
        }
    }
}

