package SmallProjectsOrHW.SearchAlgImplementations;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectionSort {
    static ArrayList<Integer> list = new CollectionInitializer(10, "arraylist").getArrayList();

    public static void main(String[] args){
        System.out.println(list.toString());
        System.out.println("sorting arrayList: ");
        SelectionSort(0);
        System.out.println(list.toString());
    }

    public static void SelectionSort(int index) {
        if(index > list.size() - 2)
            return;
        int lowest = index + 1;
        for(int i = index + 1; i < list.size(); i++){
            if(list.get(i) < list.get(lowest)){
                lowest = i;
            }
        }
        if(list.get(index) > list.get(lowest)){
            int temp = list.get(lowest);
            list.set(lowest, list.get(index));
            list.set(index, temp);
        }
        SelectionSort(index + 1);
    }

}
