package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        Object[] array = smartArray.toArray();
        ArrayList<Object> copiedArr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {

                    break;
                }
                if (j == array.length - 1) {
                    copiedArr.add(array[i]);
                }
            }
        }

        this.decoratedArray = copiedArr.toArray();
    }

    @Override
    public String operationDescription() {
        return "Remove duplicates using equals, without changing" +
                " the order(we don't use sort)";
    }
}
