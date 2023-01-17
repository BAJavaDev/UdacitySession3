package functionalinterfaces;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        return num1-num2;
    }
}
