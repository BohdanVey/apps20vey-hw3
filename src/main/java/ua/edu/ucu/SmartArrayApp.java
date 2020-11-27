package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SortDecorator;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        SmartArray studentSmartArray = new BaseArray(students);
        MyPredicate sortMethod = new MyPredicate() {

            private static final int YEAR_EQUAL = 2;
            private static final double GPA_BIGGER = 4;

            @Override
            public boolean test(Object t) {
                if (t instanceof Student) {
                    return (((Student) t).getGPA() >= GPA_BIGGER
                            && ((Student) t).getYear() == YEAR_EQUAL);
                }
                throw new IllegalArgumentException(
                        "This filter used only for Students");
            }
        };
        SmartArray studentSmartArraySort =
                new FilterDecorator(studentSmartArray, sortMethod);
        MyComparator comparatorBySurname = new MyComparator() {

            @Override
            public int compare(Object studentOne, Object studentTwo) {
                if (studentOne instanceof Student
                        && studentTwo instanceof Student) {
                    return ((Student) studentOne).getSurname().
                            compareTo(((Student) studentTwo).getSurname());
                }
                throw new IllegalArgumentException(
                        "This comparator used only for Students");
            }
        };
        SmartArray studentSmartArraySorted =
                new SortDecorator(studentSmartArraySort, comparatorBySurname);

        SmartArray studentSmartArrayDistinct =
                new DistinctDecorator(studentSmartArraySorted);

        MyFunction transformString = new MyFunction() {
            @Override
            public Object apply(Object t) {
                if (t instanceof Student) {
                    return ((Student) t).getSurname()
                            + ' ' + ((Student) t).getName();
                }
                throw new IllegalArgumentException(
                        "This transformation used only for Students");
            }
        };
        SmartArray studentsStringSmartArray
                = new MapDecorator(studentSmartArrayDistinct, transformString);
        Object[] result = studentsStringSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
