package algorithms.insertion_sort;

import algorithms.MyAlgorithms;
// help from: https://www.geeksforgeeks.org/dsa/recursive-insertion-sort/
public class InsertionRecursive implements MyAlgorithms {

    public <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType [ ] a) {
        int n = a.length;
        // Base Case:
        if (n<=1){
            return;
        }
        // sort first n-1 elements, recursion
        sort(a);


        int j = n-2;

        AnyType lastElement = a[n-1];

        // equivalent to the inner for-loop of the iterative method
        while (j >= 0 && a[j].compareTo(lastElement) > 0) {
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = lastElement;

    }

    @Override
    public String getAlgoType() {
        return "InsertionSort - Recursive";
    }
}
