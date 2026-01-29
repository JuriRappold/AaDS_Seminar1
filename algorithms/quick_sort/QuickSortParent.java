package algorithms.quick_sort;

public class QuickSortParent{
    protected final boolean useRecursive;
    private final static int CUTOFF = 1;
    //public <AnyType extends Comparable<? super AnyType>> array;

    //<AnyType extends Comparable<? super AnyType>>
    // AnyType[] a,
    public  QuickSortParent( boolean useRecursive){
        this.useRecursive = useRecursive;
        //this.array = a;
    }

    // public wrapper-method for sorting implementation type
    public <AnyType extends Comparable<? super AnyType>> void sort(AnyType[] a){
        System.out.println("Entered .sort() method");
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

    protected  <AnyType extends Comparable<? super AnyType>> void
    swapReferences(AnyType[] a, int firstEl, int secondEl){
        AnyType firstElement = a[firstEl];
        AnyType secondElement = a[secondEl];

        a[secondEl] = firstElement;
        a[firstEl] = secondElement;
    }

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
        int pivotIndex = right-1;
        int i = left-1;
        AnyType pivotEl = makePivot(a, left, right); // puts the pivot element as the second to last element

        for (int j = left; j<= pivotIndex; j++){
            if(pivotEl.compareTo(a[j]) > 0 ){
                i++;
                swapReferences(a, i, j);
            }
        }
        swapReferences(a, i+1, pivotIndex);
        return i+1; // i+1 is the new pivotIndex

    }

    //@Override
    protected <AnyType extends Comparable<? super AnyType>>
    AnyType makePivot(AnyType[] a, int firstEl, int secondEl) {
        return null;
    }

    //@Override
    public String getAlgoType() {
        return "QuickSort Parent Class";
    }
}
