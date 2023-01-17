package streams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) {
       // basic for loop
        System.out.println("Basic for loop");
        for(int i=0; i<5; i++){
            System.out.println(i);
        }

        // stream loop
        System.out.println("Stream for loop");
        IntStream.range(0,5).forEach(System.out::println);

        // animals count
        System.out.println("Animals count");
        List<String> animals = Arrays.asList("fox", "rabbit", "horse", "", "cow");
        Long countAnimals = animals.stream().count();
        System.out.println("Animals count: " + countAnimals);

        // filter out empty strings from animals
        System.out.println("No blank animals");
        Long countAnimalsNoBlanks = animals.stream().filter(x->x.isBlank())
                                                    .count();
        System.out.println("Animals count: " + countAnimalsNoBlanks);

        // Random numbers
        List<Integer> myFavouriteNumbers = new ArrayList<>();
        myFavouriteNumbers.add(5);
        myFavouriteNumbers.add(7);
        myFavouriteNumbers.add(3);
        myFavouriteNumbers.add(1);
        myFavouriteNumbers.add(20);
        myFavouriteNumbers.add(9);
        myFavouriteNumbers.add(6);

        System.out.println("Original number order");
        myFavouriteNumbers.stream().forEach(System.out::println);

        System.out.println("Top 3 numbers");
        Integer limitNum = 3;
        System.out.println("Ascending: ");
        myFavouriteNumbers.stream().sorted()
                                   .limit(limitNum)
                                   .forEach(System.out::println);

        System.out.println("Descending: ");
        myFavouriteNumbers.stream().sorted((num1,num2) -> num2-num1)
                                   .limit(limitNum)
                                   .forEach(System.out::println);




        //joining strings using map
        List<String> groceryList = Arrays.asList("Bananas", "ApPles", "chEEse", "DriNk","driNk");

        String groceries = groceryList.stream()
                                      .map(x -> x.toLowerCase())
                                      .collect(Collectors.joining(","));
        System.out.println("\ngrocery list: " + groceries);

        System.out.println("\nUnique groceries: ");
        Set<String> uniqueGroceries = groceryList.stream()
                                            .map(x -> x.toLowerCase())
                                            .collect(Collectors.toSet());
        uniqueGroceries.stream().forEach(System.out::println);

        //toCollectos for Map
        System.out.println("\n converting set to map");
        Map<String, Integer> groceriesMap = uniqueGroceries.stream().collect(
                                  Collectors.toMap(x->x, y->y.length(), (x, y) -> x, TreeMap::new)
                                );
        groceriesMap.entrySet().stream().forEach(map->{
            System.out.println("key:" +  map.getKey());
            System.out.println("value: " + map.getValue());
        });

    }
}
