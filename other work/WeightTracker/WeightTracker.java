package WeightTracker;
/*
2/3/23 Homework #2 - Weight Tracker
Javon had kept track of his daily weight and its fluctuations, and decided to process the accumulated data.

(a)         Write a method getWeightChanges that takes a non-empty ArrayList<Double> weights and returns an ArrayList<Double> that contains the differences of consecutive numbers in weights.  For example, if weights contains 145, 146.5, 146.5, 147, 146, 148, 148.5, then the result returned by getWeightChanges should contain 1.5, 0, 0.5, -1, 2, 0.5 (the size of the ArrayList returned by getWeightChanges is one less than the size of weights.)  Use only one for loop, and no other loops or recursion.

(b)         Write a method getWeights that is inverse to the getWeightChanges method from Part (a).  getWeights takes an initial weight (a double) and an ArrayList<Double> weightChanges and returns an ArrayList<Double> weights.  For example, if the initial weight is 145, and weightChanges contains 1.5, 0, 0.5, -1, 2, 0.5, the result returned by getWeights should contain 145, 146.5, 146.5, 147, 146, 148, 148.5.  Use only one “for each” loop, and no other loops or recursion.

(c)          Write a method getWeightRuns that takes a non-empty ArrayList<Double> weights that are not all equal and returns an ArrayList<Double> weightRuns.  This method should detect contiguous runs of increasing (or same) and decreasing (or same) numbers in weights, calculate the total change of weight for each run (the last number minus the first number in the run) and append the result to weightRuns.  For example, if weights contains 145, 146.5, 146.5 147, 146, 148, 148.5, then weights has three increasing/decreasing runs:

               145, 146.5, 146.5 147
               147, 146
               146, 148, 148.5

         So getWeightRuns should return an ArrayList that contains 2, -1, 2.5.  Use only one for loop, and no other loops or recursion.
 */

import java.util.ArrayList;

class WeightTracker {

    public ArrayList<Double> getWeightChanges(ArrayList<Double> list){
        ArrayList<Double> newList = new ArrayList<>();
        if(list == null) return newList;
        for(int i = 0; i < list.size() - 1; i++){
            newList.add(list.get(i) - list.get(i + 1));
        }
        return newList;
    }

    public ArrayList<Double> getWeights(double init, ArrayList<Double> list){
        ArrayList<Double> newList = new ArrayList<>();
        double temp = 0;
        for(Double x : list){
            temp += x;
            newList.add(init + temp);
        }
        return newList;
    }

    public ArrayList<Double> getWeightRuns(ArrayList<Double> list){
        ArrayList<Double> newList = new ArrayList<>();
        double temp = list.get(0);
        double totalChange = 0;
        boolean idk = true;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) < list.get(i+1)){
                idk = false;
                if(i >= 1){
                    newList.add(totalChange);
                    totalChange = 0;
                }
            }
            else if(list.get(i) > list.get(i+1)){
                idk = true;
                if(i >= 1){
                    newList.add(totalChange);
                    totalChange = 0;
                }
            }
            if(idk){
                if(list.get(i) >= list.get(i + 1)){
                    totalChange += list.get(i);
                }
            } else {
                if(list.get(i) <= list.get(i + 1)){
                    totalChange += list.get(i);
                }
            }
            newList.add(totalChange);
        }
        return newList;
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}