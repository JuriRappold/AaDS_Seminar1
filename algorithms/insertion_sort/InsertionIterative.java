package algorithms.insertion_sort;

import algorithms.MyAlgorithms;

public class InsertionIterative implements MyAlgorithms {
    /**
     * Generic Method for sorting
     * Simple insertion sort.
     * From Figure 7.2 of the book.
     * @param a an array of Comparable items.
     */
    public <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType [ ] a ) { // T(N) = O(N^2)

        int j;

        // loops through the given array
        for( int p = 1; p < a.length; p++ ) { // T(N) = O(N)
            AnyType tmp = a[ p ]; // saves current position in the array
            /*
            loops from p to the beginning & compares p element to the element in the position before j (j-1)
                --> if p is smaller than j-1, j retains the value of j-1
                --> if p is bigger, break the for-loop, j retains the value of p, then increase p & start again
            ---
            `j > 0` => normal for-loop limit
            `&& tmp.compareTo( a[ j - 1 ] ) < 0` => if true: tmp < a[j-1] ==> a[j] = a[ j - 1 ]
                                                 => if false: tmp > a[j-1] ==> a[j] = tmp
            ---
            .compareTo() --> returns negative int if the calling element is smaller than the one in brackets
                         --> returns positive int if the calling element is bigger than the one in brackets
                         --> returns 0 int if the calling element is equal to the one in brackets
            */
            for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- ) // T(N) = O(N)
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }



    @Override
    public String getAlgoType() {
        return "InsertionSort - Iterative";
    }
}
