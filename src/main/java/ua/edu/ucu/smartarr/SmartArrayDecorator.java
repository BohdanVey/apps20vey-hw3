package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected Object[] decoratedArray;
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
        decoratedArray = smartArray.toArray();
    }

    @Override
    public Object[] toArray() {
        return decoratedArray.clone();
    }


    @Override
    public int size() {
        return decoratedArray.length;
    }
}
