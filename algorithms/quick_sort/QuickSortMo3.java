package algorithms.quick_sort;

import algorithms.MyAlgorithms;

import java.util.Arrays;

public class QuickSortMo3 implements MyAlgorithms {
    private final boolean useRecursive;
    private final static int CUTOFF = 1; // if 0 will throw error bc right = -1, but will have finished sorting

    public QuickSortMo3(boolean useRecursive){
        this.useRecursive = useRecursive;
    }

    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a){
        int left = 0;
        int right = a.length -1;
        if(useRecursive)
            sortRecursive(a, left, right);
        else
            sortIterative(a, left, right);
    }

    // recursive version
    private <AnyType extends Comparable<? super AnyType>> void
    sortRecursive(AnyType[] a, int left, int right){ // throws error after being done... i think thats why the cutoff exits
        if( left + CUTOFF <= right ) {
//            System.out.println(Arrays.toString(a));
//            AnyType pivot = median3( a, left, right );
//
//            // Begin partitioning
//            int i = left, j = right - 1;
//            for( ; ; )
//            {
//                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
//                System.out.println("i: " + i);
//                while( a[ --j ].compareTo( pivot ) > 0 ) { }
//                System.out.println("j: " + j);
//                if( i < j )
//                    swapReferences( a, i, j );
//                else
//                    break;
//            }
//
//            swapReferences( a, i, right - 1 ); // Restore pivot
            int pivotIndex = partioning(a, left, right); // returns pivot index

            sortRecursive( a, left, pivotIndex - 1 ); // Sort small elements
            sortRecursive( a, pivotIndex + 1, right ); // Sort large elements
        }
        else // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }

    // iterative version
    private <AnyType extends Comparable<? super AnyType>> void
    sortIterative(AnyType[] a, int left, int right){
        // O(N^2) rn, thats the worst outcome for QuickSort
//        if( left + CUTOFF <= right){
//            AnyType pivot = median3(a, left, right);
//
//            // Begin partitioning
//            int i = left, j = right - 1;
//            for( ; ; )
//            {
//                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
//                while( a[ --j ].compareTo( pivot ) > 0 ) { }
//                if( i < j )
//                    swapReferences( a, i, j );
//                else// put iterative stuff; here change i & j?
//                    break;
//            }
//
//            swapReferences( a, i, right - 1 ); // Restore pivot
//        } else
//            insertionSort( a, left, right );
        // Create an auxiliary stack
        int[] stack = new int[right - left +1];

        // initialize top of stack
        int top = -1;

        // push initial values left and right onto the stack
        // ++top => increments to new value & returns new value
        // top++ => returns value & then increments
        stack[++top] = left;
        stack[++top] = right;

        // keep popping from stack until its empty:
        while (top>= 0){
            // pop h & l
            right = stack[top--];
            left = stack[top--];

            int pi = partioning(a, left, right);
            // If there are elements on left side of pivot,
            // then push left side to stack
            if(pi - 1 > left){
                stack[++top] = left;
                stack[++top] = pi - 1;
            }
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (pi + 1 < right) {
                stack[++top] = pi + 1;
                stack[++top] = right;
            }

        }



    }

    // wrapper for private sorting algo implementation
//    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a, int left, int right){
//        if(useRecursive)
//            sortRecursive(a, left, right);
//        else
//            sortIterative(a, left, right);
//    }


    private <AnyType extends Comparable<? super AnyType>> void
    swapReferences(AnyType[] a, int firstEl, int secondEl){
        AnyType firstElement = a[firstEl];
        AnyType secondElement = a[secondEl];

        a[secondEl] = firstElement;
        a[firstEl] = secondElement;
    }

    /**
     * Return median of firstEl, center, and lastEl.
     * Order these and hide the pivot.
     */
    private <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int firsEl, int lastEl )
    {
        int center = ( firsEl + lastEl ) / 2;
        if( a[ center ].compareTo( a[ firsEl ] ) < 0 )
            swapReferences( a, firsEl, center );
        if( a[ lastEl ].compareTo( a[ firsEl ] ) < 0 )
            swapReferences( a, firsEl, lastEl );
        if( a[ lastEl ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, lastEl );

        // Place pivot at position right - 1
        swapReferences( a, center, lastEl - 1 );
        return a[ lastEl - 1 ];
    }


    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    private <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a, int start, int end)
    {
        System.out.println("Doing Insertion Sort");
        int j;

        for( int p = start; p < end; p++ )
        {
            AnyType tmp = a[ p ];
            for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    private <AnyType extends Comparable<? super AnyType>>
    int partioning(AnyType[] a, int left, int right){
//        int pivotIndex = right -1;
//        int i = left;
//        int j =  left+ 1;// left+1;
//        AnyType pivotElement = median3(a, left, right); // median3() places the pivot element on second to last index
//        System.out.println("Pivot: "+pivotElement);
//
//        while(j<pivotIndex){// O(N)
//            if(pivotElement.compareTo( a[j] ) > 0){
//                i++;
//                swapReferences(a, i, j);
//            }
//            j++;
//        }
//        swapReferences(a, i+1, pivotIndex);
//        System.out.println(Arrays.toString(a));
//        pivotIndex = i+1;
//        return pivotIndex;
//        down below is the for-loop implementation of the above code
        int pivotIndex = right-1;
        int i = left-1;
        AnyType pivotEl = median3(a, left, right); // puts the pivot element as the second to last element

        for (int j = left; j<= pivotIndex; j++){
            if(pivotEl.compareTo(a[j]) > 0 ){
                i++;
                swapReferences(a, i, j);
            }
        }
        swapReferences(a, i+1, pivotIndex);
        return i+1; // i+1 is the new pivotIndex

    }





    @Override
    public String getAlgoType() {
        if(useRecursive)
            return "QuickSortMo3 - Recursive";
        else
            return "QuickSortMo3 - Iterative";
    }
}
