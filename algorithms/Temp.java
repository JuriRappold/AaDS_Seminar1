package algorithms;


import algorithms.insertion_sort.InsertionIterative;
import algorithms.insertion_sort.InsertionRecursive;
import algorithms.quick_sort.QuickSortFirst;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args){
        InsertionIterative algo1 = new InsertionIterative(); // works as intended
        InsertionRecursive algo2 = new InsertionRecursive(); // works as intended

//        QuickSortFirst recursiveFirst = new QuickSortFirst(true);
        Integer[] array = new Integer[5];
        array[0] = 12;
        array[1] = 11;
        array[2] = 13;
        array[3] = 5;
        array[4] = 6;
        System.out.println("Pre-sorted Array: " + Arrays.toString(array));
        //algo1.sort(array);
        //algo2.sort(array);
//        recursiveFirst.sort(array, 0, array.length);
        System.out.println("After-sorted Array: "+ Arrays.toString(array));


    }
}
