package algorithms.quick_sort;

import algorithms.MyAlgorithms;

public class QuickSortMo3 implements MyAlgorithms {
    private final boolean useRecursive;
    private final static int CUTOFF = 10;

    public QuickSortMo3(boolean useRecursive){
        this.useRecursive = useRecursive;
    }

    // recursive version
    private <AnyType extends Comparable<? super AnyType>> void sortRecursive(AnyType[] a, int left, int right){
        if( left + CUTOFF <= right )
        {
            AnyType pivot = median3( a, left, right );

            // Begin partitioning
            int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ) { }
                while( a[ --j ].compareTo( pivot ) > 0 ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

            swapReferences( a, i, right - 1 ); // Restore pivot

            sortRecursive( a, left, i - 1 ); // Sort small elements
            sortRecursive( a, i + 1, right ); // Sort large elements
        }
        else // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }

    // iterative version
    private <AnyType extends Comparable<? super AnyType>> void sortIterative(AnyType[] a, int left, int right){}

    // wrapper for private sorting algo implementation
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a, int left, int right){
        if(useRecursive)
            sortRecursive(a, left, right);
        else
            sortIterative(a, left, right);
    }


    private <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int left, int right){
        AnyType leftElement = a[left];
        AnyType rightElement = a[right];

        a[right] = leftElement;
        a[left] = rightElement;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private <AnyType extends Comparable<? super AnyType>>
    AnyType median3( AnyType [ ] a, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( a[ center ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, center );
        if( a[ right ].compareTo( a[ left ] ) < 0 )
            swapReferences( a, left, right );
        if( a[ right ].compareTo( a[ center ] ) < 0 )
            swapReferences( a, center, right );

        // Place pivot at position right - 1
        swapReferences( a, center, right - 1 );
        return a[ right - 1 ];
    }


    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    public <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a, int start, int end)
    {
        int j;

        for( int p = start; p < end; p++ )
        {
            AnyType tmp = a[ p ];
            for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }



    @Override
    public String getAlgoType() {
        if(useRecursive)
            return "QuickSortMo3 - Recursive";
        else
            return "QuickSortMo3 - Iterative";
    }
}
