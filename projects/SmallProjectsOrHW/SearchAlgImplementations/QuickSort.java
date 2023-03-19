package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.*;
public class QuickSort {
    static int[] array = new CollectionInitializer(10, "array").getArray();
    public static int[] QuickSort(int[] array, int length) {
        if(length < 2){
            return array;
        }
        int pivot=0;

        int temp;

        for(int i=1; i<length; i++) {
            if(array[i] <= array[0]) {
                pivot++;
                temp = array[i];
                array[i] = array[pivot];
                array[pivot] = temp;
            }
        }

        temp = array[0];
        array[0] = array[pivot];
        array[pivot] = temp;

        int[] left = QuickSort(array,pivot);

        int[] arr2 = Arrays.copyOfRange(array, pivot+1, length);

        int[] right = QuickSort(arr2, length-pivot-1);

        int[] holder = new int[length]; //final array, to merge everything together

        System.arraycopy(left, 0, holder, 0, pivot);
        holder[pivot] = array[pivot];
        for(int i=pivot+1; i<length; i++) {
            holder[i] = right[i-pivot-1];
        }
        return holder;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array));
        System.out.println("sorted array: ");
        QuickSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
