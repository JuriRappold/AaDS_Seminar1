# QuickSortFirst.java
*first recursive implementation attempt*
```Java
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

```

*entire class for a second*
```Java
// Fields: to determine which implementation to use (recursive or iterative):
    private final boolean useRecursive;
    private static final int CUTOFF = 1;
    // Constructor
    public QuickSortFirst(boolean useRecursive){
        this.useRecursive = useRecursive;
    }

    // recursive algorithm:
    private <AnyType extends Comparable<? super AnyType>> void sortRecursive(AnyType[] a, int left, int right){
        if( left + CUTOFF <= right){
            int pivotIndex = partioning(a, left, right); // returns pivot index

            sortRecursive( a, left, pivotIndex - 1 ); // Sort small elements
            sortRecursive( a, pivotIndex + 1, right ); // Sort large elements
        }
        else // Do an insertion sort on the subarray
            insertionSort( a, left, right );

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

    private <AnyType extends Comparable<? super AnyType>>
    int partioning(AnyType[] a, int left, int right){
        int pivotIndex = right-1;
        int i = left-1;
        AnyType pivotEl = makePivot(a); // moves the first element to the second to last position

        for (int j = left; j<= pivotIndex; j++){
            if(pivotEl.compareTo(a[j]) > 0 ){
                i++;
                swapReferences(a, i, j);
            }
        }
        swapReferences(a, i+1, pivotIndex);
        return i+1; // i+1 is the new pivotIndex
    }

    private static <AnyType extends Comparable<? super AnyType>> void
    swapReferences(AnyType[] a, int first, int second){
        AnyType firstElement = a[first];
        AnyType secondElement = a[second];

        a[second] = firstElement;
        a[first] = secondElement;
    }


    /**
     *
     * @param a, the array to be sorted
     * @return the first element that has been moved into the second to last slot
     * @param <AnyType> gonna be an Integer
     */
    private <AnyType extends Comparable<? super AnyType>>
    AnyType makePivot(AnyType[] a){
        int secondToLast = a.length - 2;
        swapReferences(a, 0, secondToLast);
        return a[secondToLast];
    }


    /**
     *
     * @param a of <AnyType> the arrray to be sorted
     * @param start the margin in which the method should start sorting
     * @param end the margin in which the method should stop sorting
     * @param <AnyType> gonna be an Integer
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

    @Override
    public String getAlgoType() {
        if(useRecursive)
            return "QuickSortFirst - Recursive";
        else
            return "QuickSortFirst - Iterative";
    }
```