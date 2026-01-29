package algorithms.quick_sort;

import algorithms.MyAlgorithms;
import java.util.Arrays;

public class QuickSortFirst implements MyAlgorithms {
    // Fields: to determine which implementation to use (recursive or iterative):
    private final boolean useRecursive;
    // Constructor
    public QuickSortFirst(boolean useRecursive){
        this.useRecursive = useRecursive;
    }

    // recursive algorithm:
    private <AnyType extends Comparable<? super AnyType>> void sortRecursive(AnyType[] a, int left, int right){
        // Base Case
        if(a.length<=1)
            return;

        AnyType pivot = a[left];
        System.out.println(pivot);
        int pivotIndex = left;
        int lesserIndex = left; // pivot-index -1
        int greaterIndex = right-1; // pivot-index +1
//        System.out.println(lesserIndex);
//        System.out.println(greaterIndex);

//        for(int i = lesserIndex; i < a.length; i++){
//            if(pivot.compareTo(a[i]) < 0){ // if its bigger than the pivot:
//                AnyType temp = a[lesserIndex];
//                a[lesserIndex] = a[i];
//
//            }
//        }
        for( ; ; )
        {
            while( a[ ++lesserIndex ].compareTo( pivot ) > 0) {//run through list until a bigger element than the pivot is met
//                System.out.println("LesserIndex: " + lesserIndex);
            }
            while( a[ --greaterIndex ].compareTo( pivot ) < 0) { //run through list until a smaller element than the pivot is met
//                System.out.println("GreaterIndex: " + greaterIndex);
            }
            if( lesserIndex < greaterIndex )
                swapReferences( a, lesserIndex, greaterIndex );
            else
                break;
        }

        swapReferences( a, lesserIndex, right-1 ); // Restore pivot

        // Recursive calls
        System.out.println("Recursion");
        System.out.println(Arrays.toString(a));
        sortRecursive(a, left, lesserIndex - 1); // sort sublist of lesser elements
        sortRecursive(a, lesserIndex + 1, right); // sort sublist of greater elements


    }

    // iterative algorithm
    private <AnyType extends Comparable<? super AnyType>> void sortIterative(AnyType[] a, int left, int right){}

    // wrapper for private sorting algo implementation
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a, int left, int right){
        if(useRecursive)
            sortRecursive(a, left, right);
        else
            sortIterative(a, left, right);
    }

    private static <AnyType extends Comparable<? super AnyType>> void
    swapReferences(AnyType[] a, int first, int second){
        AnyType firstElement = a[first];
        AnyType secondElement = a[second];

        a[second] = firstElement;
        a[first] = secondElement;
    }



    @Override
    public String getAlgoType() {
        if(useRecursive)
            return "QuickSortFirst - Recursive";
        else
            return "QuickSortFirst - Iterative";
    }
}
