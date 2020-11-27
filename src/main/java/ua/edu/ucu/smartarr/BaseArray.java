package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] baseArray;

    public BaseArray(Object[] baseArray) {
        this.baseArray = baseArray.clone();
    }

    @Override
    public Object[] toArray() {
        return baseArray.clone();
    }

    @Override
    public String operationDescription() {
        return "This is not Decorator.";
    }

    @Override
    public int size() {
        return baseArray.length;
    }

    public Object[] getBaseArray() {
        return baseArray;
    }

    public void setBaseArray(Object[] arr) {
        baseArray = arr.clone();
    }
}
