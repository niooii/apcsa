
package SmallProjectsOrHW.SearchAlgImplementations;

import java.util.ArrayList;

public class CollectionInitializer {

    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> taken = new ArrayList<>();

    public static int random() {
        return ((int) (Math.random() * 4999) + 1);
    }

    public static void populateArrayList(int numberOfElements) {

        for (int i = 0; i < numberOfElements; i++) {
            int rnum = random();
            while (taken.contains(rnum)) {
                rnum = random();
            }
            list.add(rnum);
            taken.add(rnum);
        }
    }


    public CollectionInitializer(int numberOfElements, String type){
        switch(type){
            case "arraylist":
                populateArrayList(numberOfElements);

        }

    }
    public ArrayList<Integer> getArrayList() {
        return list;
    }

}
