package Operations;

import java.util.List;

public class Operations {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,5,2,6,3,8,9);

        /**
         * .anyMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if one of the elements from the stream meets the condition from predicate
         */
        boolean hasAnEvenNumber = list.stream()
                .anyMatch(integer -> integer % 2 == 0);

        /**
         * .allMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if all the elements from the stream meets the condition from predicate
         */
        boolean allEven = list.stream()
                .allMatch(integer -> integer % 2 == 0);

        /**
         * .noneMatch()
         * It's terminal operator that takes parameter a Predicate
         * The predicate returns true if none of the elements from the stream meets the condition from predicate
         * (if one element from the stream meets the condition will return false)
         */
        boolean noneMatch = list.stream()
                .noneMatch(integer -> integer % 2 == 0);


    }
}
