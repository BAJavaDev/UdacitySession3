package Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExercise {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(6,5,5,5,5,5,5,5,4,4,4,4,4,3,3,3,2,2,10,10,10,10,2);
        System.out.println("Imperative:");
        printNumList(getSmallestDistinctNumbers(intList, 5));

        System.out.println("\nStreams:");
        printNumList(getSmallestDistinctNumbersStream(intList, 5));
    }

    private static List<Integer> getSmallestDistinctNumbers(List<Integer> numList, int smallestLimit){
        Set<Integer> numSet = new HashSet<>();
        numSet.addAll(numList);

        List<Integer> listOfUniqueNums = new ArrayList<>(numSet);
        Collections.sort(listOfUniqueNums);

        List<Integer> answer = new ArrayList<>();
        for (int i=0; i< smallestLimit; i++) {
            answer.add(listOfUniqueNums.get(i));
        }

        return answer;
    }

    private static List<Integer> getSmallestDistinctNumbersStream(List<Integer> numList, int topN){
        return numList.stream()
    }


    private static void printNumList(List<Integer> numList){
        for(Integer num: numList) {
            System.out.println(num);
        }
    }
}
