package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.Arrays;

import static SmallProjectsOrHW.LinearAndBinarySearch.LinearAndBinarySearch.reset;

public class InsertionSort {
    static int[] array = new CollectionInitializer(10, "array").getArray();
    public static void main(String[] args){
        System.out.println(Arrays.toString(array));
        InsertionSort(array, 0);
        System.out.println("sorted array:");
        System.out.println(Arrays.toString(array));
    }
    public static void InsertionSort(int[] array, int index) {
        if(index >= array.length){
            insert(array, index - 1, index - 1);
            return;
        }
        insert(array, index, index);
        if(isSorted(array, index)) {
            InsertionSort(array, index + 1);
        } else{
            while(!isSorted(array, index)) {
                insert(array, index, index);
            }
            InsertionSort(array, index + 1);
        }
    }

    public static void insert(int[] array, int maxIndex, int element) {
        for(int i = 0; i < maxIndex; i++){
            if(array[element] < array[i]){
                int elementholder = array[element];
                array[element] = array[i];
                array[i] = elementholder;
                break;
            }
        }
    }

    public static boolean isSorted(int[] array, int index){
        for(int i = 0; i < index; i++){
            if(!(array[i] < array[i + 1])){
                return false;
            }
        }
        return true;
    }
}

