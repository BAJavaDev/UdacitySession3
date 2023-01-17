package Lamdas;

import java.util.List;
import java.util.function.Predicate;

public class Lamda {
    public static void main(String[] args) {
        List<String> input = List.of("hello", "\t   ", "world", "", "\t", " ", "goodbye", "  ");

        // without lamda
        long numberOfWhitespaceStrings =
                countMatchingStrings(input,
                        new Predicate<String>() {
                            @Override
                            public boolean test(String s) {
                                return s.isBlank();
                            }
                        });

        // with lamda
        long numberOfWhitespaceStrings2 = countMatchingStrings(input,   x -> x.isBlank()    );
    }

    public static long countMatchingStrings(List<String> input, Predicate<String> condition) {
        return input.stream().filter(condition).count();
    }
}
