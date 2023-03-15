package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    int[] array = new CollectionInitializer(10, "array").getArray();

    public static void debug(ArrayList<int[]> holder){
        for (int i=0; i<holder.size(); i++){
            int[] tmp = holder.get(i);
                System.out.print(Arrays.toString(tmp));
            if(i != holder.size() - 1) System.out.print(", ");
        }
    }

    public static void main(String[] args){
        int[] array = {8, 5, -9, 14, 0, -1, -7, 3}; // add case for odd number of elements later
        split(array);
    }

    public static void MergeSort(){

    }

    public static ArrayList<int[]> split(int[] array){
        int debug = 1;
        int iterations = 0;
        ArrayList<int[]> holder = new ArrayList<>();
        holder.add(array);
        int tempLength = array.length/2;
        int orgSize = holder.size();
        while(holder.get(0).length != 1) {
            for (int k = 0; k < orgSize; k++) {
                System.out.println("splitting array " + (k + 1));
                int[] holder1 = new int[tempLength];
                for (int i = 0; i < tempLength; i++) {
                    holder1[i] = holder.get(k)[i];
                }
                int[] holder2 = new int[tempLength];
                for (int i = 0; i < tempLength; i++) {
                    holder2[i] = holder.get(k)[i + tempLength];
                }
                holder.add(holder1);
                holder.add(holder2);
                iterations++;
            }
            for(int i = iterations - 1; i >= 0; i--){
                holder.remove(i);
            }
            orgSize = holder.size();
            System.out.println("split " + debug + ":");
            debug(holder);
            debug++;
            tempLength = holder.get(holder.size() - 1).length/2;
            iterations = 0;
        }


        return holder;
    }

    public static int[] merge(ArrayList<int[]> list){

        return new int[]{1,2};
    }

    /*
1st split
{37, 29, 19, 48} {23, 55, 74, 12}
2nd split
{37, 29} {19, 48} {23, 55} {74, 12}
3rd split
{37} {29} {19} {48} {23} {55} {74} {12}
1st merge
{29, 37} {19, 48} {23, 55} {12, 74}
2nd merge
{19, 29, 37, 48} {12, 23, 55, 74}
3rd merge
{12, 19, 23, 29, 37, 48, 55, 74}
     */
}
