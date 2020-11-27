package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    protected Object[] baseArray;

    public BaseArray(Object[] baseArray){
        this.baseArray = baseArray.clone(); // Ми копіюємо щоб не змінювати заданий нам масив
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
}
