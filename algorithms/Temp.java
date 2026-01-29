package algorithms;


import algorithms.insertion_sort.InsertionIterative;
import algorithms.insertion_sort.InsertionRecursive;

import java.util.Arrays;

public class Temp {
    public static void main(String[] args){
        InsertionIterative algo1 = new InsertionIterative(); // works as intended
        InsertionRecursive algo2 = new InsertionRecursive();
        Integer[] array = new Integer[5];
        array[0] = 12;
        array[1] = 11;
        array[2] = 13;
        array[3] = 5;
        array[4] = 6;
        System.out.println("Pre-sorted Array: " + Arrays.toString(array));
        //algo1.sort(array);
        algo2.sort(array);
        System.out.println("After-sorted Array: "+ Arrays.toString(array));


    }
}
