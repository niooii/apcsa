package PascalsTriangle;

import java.util.*;
class Main{
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of lines:");
        int lines = sc.nextInt();
        for(int i = 0; i < lines; i++){
            System.out.println(Arrays.toString(Layer(i)));
        }
    }

    /*
    public static int[] printTriangle(int layers){
        if(currentlayer == layers){
            list.add(0, new int[]{1});
            return null;
        }
        list.add(0, new int[]{})
    }

     */

    public static int[] Layer(int n) {
        int[] x = new int[n + 1];
        if (n == 0) {
            x[0] = 1;
            return x;
        }
        int[] ppt = Layer(n - 1);
        x[0] = x[n] = 1;
        for (int i = 1; i < ppt.length; i++) {
            x[i] = ppt[i - 1] + ppt[i];
        }
        return x;
    }
}
//finish