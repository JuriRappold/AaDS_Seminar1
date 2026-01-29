package algorithms.quick_sort;

import algorithms.MyAlgorithms;

public class QuickSortMo3 implements MyAlgorithms {
    private boolean useRecursive;

    public QuickSortMo3(boolean useRecursive){
        this.useRecursive = useRecursive;
    }




    @Override
    public String getAlgoType() {
        if(useRecursive)
            return "QuickSortFirst - Recursive";
        else
            return "QuickSortFirst - Iterative";
    }
}
