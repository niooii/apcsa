package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort { //why did this take so long
    static int splitcounter = 1;
    static int mergecounter = 1;

    static int[] array = new CollectionInitializer(16, "array").getArray();

    public static void debug(ArrayList<int[]> holder, String string){
        System.out.println();
        if(string.equals("merge")){
            System.out.println(string + " " + mergecounter + ":");
        } else {
            System.out.println(string + " " + splitcounter + ":");
        }

        for (int i=0; i<holder.size(); i++){
            int[] tmp = holder.get(i);
                System.out.print(Arrays.toString(tmp));
            if(i != holder.size() - 1) System.out.print(", ");
        }
    }

    public static void main(String[] args){
        int[] yes = MergeSort(array);
        System.out.println();
        System.out.println("finished: " + Arrays.toString(yes));
    }

    public static int[] MergeSort(int[] array){
        return merge(split(array));
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
            debug(holder, "split");
            splitcounter++;
            tempLength = holder.get(holder.size() - 1).length/2;
            iterations = 0;
        }
        return holder;
    }

    public static int[] merge(ArrayList<int[]> list){
        ArrayList<int[]> holder = new ArrayList<>();
        int[] array = new int[list.size()];
        while(list.size() != 1) {
            for (int i = 0; i < list.size() - 1; i++) {
                int[] holder1 = new int[list.get(i).length * 2];
                int temp = 0;
                int counter1 = 0;
                int counter2 = 0;
                if (list.get(i).length == 1) {
                    if (list.get(i + 1)[0] < list.get(i)[0]) {
                        holder1[temp++] = list.get(i + 1)[0];
                        holder1[temp] = list.get(i)[0];
                    } else {
                        holder1[temp++] = list.get(i)[0];
                        holder1[temp] = list.get(i + 1)[0];
                    }
                    i++;
                    holder.add(holder1);
                } else {
                    for(int j = 0; j < list.get(i).length * 2 /* is four */; j++) {
                        if(counter2 == list.get(i).length){
                            holder1[temp++] = list.get(i + 1)[counter1];
                            counter1++;
                        } else if(counter1 == list.get(i+1).length){
                            holder1[temp++] = list.get(i)[counter2];
                            counter2++;
                        } else {
                            if (list.get(i + 1)[counter1] < list.get(i)[counter2]) {
                                holder1[temp++] = list.get(i + 1)[counter1];
                                counter1++;
                            } else {
                                holder1[temp++] = list.get(i)[counter2];
                                counter2++;
                            }
                        }
                    }
                    i++;
                    holder.add(holder1);
                }
            }
            list.clear();
            list.addAll(holder);
            debug(list, "merge");
            mergecounter++;
            holder.clear();
        }
        for(int i = 0; i < array.length; i++){
            array[i] = list.get(0)[i];
        }
        return array;
    }

    public boolean greaterThan(int a, int b){
        return a > b;
    }
}
