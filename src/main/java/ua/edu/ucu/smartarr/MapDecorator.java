package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.decoratedArray = Arrays.stream(smartArray.toArray()).map(func::apply).toArray();
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }
}
