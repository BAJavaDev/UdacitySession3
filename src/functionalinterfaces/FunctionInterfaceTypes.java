package functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionInterfaceTypes {
    public static void main(String[] args) {
        // BiFunction
        BiFunction<Integer, Integer, String> addFunc =
                (Integer num1, Integer num2) -> num1 + " " + num2;
        addFunc.apply(6,8);

        // Predicate - accepts 1 parameter and returns boolean
        Predicate<String> checkLength = (str) -> str.length() < 5;
        checkLength.test("yugyg");

        //BiPredicate - accepts 2 parameters and return boolean
        BiPredicate<String, String> checkEquals = (str1, str2) -> str1.equals(str2);
        checkEquals.test("blah", "blah");

        //BiConsumer - does not return a value
        BiConsumer<String, String> printStringEquals = (s1, s2) -> {
            if(s1.equals(s2)){
                System.out.println("These are equal");
            } else {
                System.out.println("These are not equal");
            }
        };
        printStringEquals.accept("nkjn", "hvjhv");

        //Supplier - accepts no parameters only
        Supplier<String> getName = () -> {
          return "Brandon";
        };
        getName.get();

        // Sort collection using comparator
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(1);
        nums.add(0);
        nums.add(7);
        nums.add(4);
        nums.add(3);

        Collections.sort(nums, new IntegerComparator());
        Collections.sort(nums, (num1,num2) -> num1-num2);

        // custom functional interface
        CalculatorInterface<Integer> calculatorInterface = (num1, num2) -> num1 + num2;
        calculatorInterface.performOperation(5,8);
    }
}
