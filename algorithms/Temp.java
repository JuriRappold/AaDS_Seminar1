package algorithms;


import algorithms.insertion_sort.InsertionIterative;
import algorithms.insertion_sort.InsertionRecursive;
import algorithms.quick_sort.QuickSortFirst;
import algorithms.quick_sort.QuickSortMo3;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args){
        InsertionIterative algo1 = new InsertionIterative(); // works as intended
        InsertionRecursive algo2 = new InsertionRecursive(); // works as intended

        QuickSortFirst recursiveFirst = new QuickSortFirst(true);

        // works as intended both recursive & iterative
        QuickSortMo3 recursiveMo3 = new QuickSortMo3(true);
        Integer[] array = new Integer[5];
        array[0] = 12;
        array[1] = 11;
        array[2] = 13;
        array[3] = 5;
        array[4] = 6;
        System.out.println("Pre-sorted Array: " + Arrays.toString(array));
        int lastElIndex = array.length-1;
//        recursiveMo3.sort(array);
//        recursiveFirst.sort(array);


        recursiveFirst.sort( array );
        System.out.println("After-sorted Array: "+ Arrays.toString(array));


    }
}
