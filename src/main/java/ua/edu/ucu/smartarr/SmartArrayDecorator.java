package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    private Object[] decoratedArray;
    private SmartArray smartArray;

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

    public void setDecoratedArray(Object[] decoratedArraySet) {
        this.decoratedArray = decoratedArraySet;
    }
    public Object[] getDecoratedArray(){
        return decoratedArray;
    }
}
