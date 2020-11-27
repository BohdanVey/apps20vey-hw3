package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.setDecoratedArray(Arrays.stream(
                smartArray.toArray()).sorted(cmp).toArray());
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }
}
