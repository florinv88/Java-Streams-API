package Operations;

import java.util.List;
import java.util.stream.Stream;

public class Operations {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,5,2,6,3,8,9);
        List<String> listStrings = List.of("abc","qwerty","asdsad");
        List<List<Integer>> datasource = List.of(
                List.of(1,2,3,4,5,6),
                List.of(3,4,5,6),
                List.of(1,2)
        );

        /*
         * .anyMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if one of the elements from the stream meets the condition from predicate
         */
        boolean hasAnEvenNumber = list.stream()
                .anyMatch(integer -> integer % 2 == 0);

        /*
         * .allMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if all the elements from the stream meets the condition from predicate
         */
        boolean allEven = list.stream()
                .allMatch(integer -> integer % 2 == 0);

        /*
         * .noneMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if none of the elements from the stream meets the condition from predicate
         * (if one element from the stream meets the condition will return false)
         */
        boolean noneMatch = list.stream()
                .noneMatch(integer -> integer % 2 == 0);


        /*
         * map() Stream -> Stream
         * mapToInt() Stream -> IntStream
         * mapToLong() Stream -> LongStream
         * mapToDouble() Stream -> DoubleStream
         * mapToObj()   ...  -> Stream
        */
        Integer sumLength = listStrings
                .stream()   // a stream of strings
                .map(s -> s.length())  // 3 6 6
                .reduce(0, (a, b) -> a + b);
        //0+3
        //3+6
        //9+6

        Integer sumLength2 = listStrings
                .stream()   // a stream of strings
                .mapToInt(s -> s.length()) // Stream --> IntStream
                .sum();

        Stream<String> reverseWords = listStrings.stream()   // stream of the initial strings
                .map(s -> new StringBuilder(s).reverse().toString());   // map transforms the strings in their reverse


        /*
         * .flatMap()
         * .flatMapToInt()
         * A flatMap transform a datasource into a stream
         * - it used when we have a datasource that contains another datasource that we want to extract
         */

        Integer sumUsingFlatMap = datasource.stream()  //  Stream <List<Integer>>  : [1,2,3,4,5,6] [3,4,5,6] [1,2]
                .flatMap(lista -> lista.stream()) // Streamm of Integers [1,2,3,4,5,6,3,4,5,6,1,2]
                .reduce(0, (a,b) -> a + b); //sum
        System.out.println(sumUsingFlatMap);

    }
}
