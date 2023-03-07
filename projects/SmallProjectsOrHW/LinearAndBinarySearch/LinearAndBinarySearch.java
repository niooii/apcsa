/*
Small Project / HW [30 points] - Comparing Sequential (Linear) Search and Binary Search:
 Write a Java program to:
1)      Declare an int array of 1000 elements
2)      Randomly assign distinct numbers between 1 and 5000 (1 inclusive, 5000 exclusive)  into the array
3)      Prompt the user to enter a number between 1 and 5000
4)      In your program, write a method named linearSearch to use sequential (linear) search to find the number entered by the user and print the number of comparisons it takes to find the target number

Example:
      When the program starts, it prints
                  Enter a number you would like to search:

  Then the user chooses a number between 1 and 5000, say the user enters 59

      Your program prints:
                  Number of comparisons: 78 times

5)      Write a method named binarySearch, and use Binary search to look for a number entered by the user, and your program will print the number of comparisons. Reminder: In order to perform the binary search, you will need to arrange the numbers in ascending or descending order first!

6)      In your main method, use iterations or recursions to call the sequential search method 1000 times with randomly generated targets, and calculate the average number of comparisons.

7)      In your main method, use iterations or recursions to call the binary search method 1000 times with randomly generated targets, and calculate the average number of comparisons.

8) Write a paragraph summarizing your results and findings.
*/

package SmallProjectsOrHW.LinearAndBinarySearch;

import java.util.*;

public class LinearAndBinarySearch {

    //declarations ------------------------
    static int totalcomparisonsBinary = 0;
    static int totalcomparisonsLinear = 0;
    static int[] arr = new int[1000];
    static Scanner sc = new Scanner(System.in);

    static int comparisons = 0;
    static int index = -1;

    //methods -----------------------
    public static int random() {
        return ((int) (Math.random() * 4999) + 1);
    }

    public static void reset() {
        comparisons = 0;
        index = -1;
    }

    public static void populate(int[] arr) {
        ArrayList<Integer> taken = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            int rnum = random();
            while (taken.contains(rnum)) {
                rnum = random();
            }
            arr[i] = rnum;
            taken.add(rnum);
        }
        System.out.println("Populated with distinct values: " + Arrays.toString(arr));
    }

    public static void linearSearch(int[] arr, int target, boolean print) {
        for(int i = 0; i < arr.length; i++){
            comparisons++;
            if(arr[i] == target){
                index = i;
                break;
            }
        }
        if(print) {
            if (index != -1) {
                System.out.println("Index found: " + index);
            } else {
                System.out.println("Index not found :(");
            }
            System.out.println("Comparisons: " + comparisons);
        }
        totalcomparisonsLinear+=comparisons;
        reset();
    }

    public static void binarySearch(int[] arr, int target, boolean print){
        int startindex = 0;
        int endindex = arr.length - 1;
        int searchindex = arr.length/2;
        int holder;
        while(target!=arr[searchindex]){
            holder = searchindex;
            comparisons++;
            if(target > arr[searchindex]) {
                startindex = searchindex;
            } else{
                endindex = searchindex;
            }
            searchindex = startindex + (endindex-startindex)/2;
            if(searchindex == holder){
                searchindex = -1;
                break;
            }
        }
        index = searchindex;
        if(print){
            if(index != -1){
                System.out.println("Index found: " + index);
            } else{
                System.out.println("Index not found :(");
            }
            System.out.println("Comparisons: " + comparisons);
        }
        totalcomparisonsBinary+=comparisons;
        reset();
    }

    public static void main(String[] args) throws InterruptedException {
        populate(arr);
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.print("Enter a number to search for: ");
        int num = sc.nextInt();
        System.out.println();
        System.out.println("Linear search: ");
        linearSearch(arr, num, true);
        System.out.println();
        System.out.println("Binary search: ");
        binarySearch(arr, num, true);
        System.out.println();
        System.out.println("Beginning 999 tests w/ random targets... ");
        Thread.sleep(1000);
        int test = 1;
        for(; test <= 1000; test++){
            int rnum = random();
            linearSearch(arr, rnum, false);
            binarySearch(arr, rnum, false);
        }
        System.out.println("Linear comparisons: " + totalcomparisonsLinear);
        System.out.println("Binary comparisons: " + totalcomparisonsBinary);
    }
}


