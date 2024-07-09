package examples;

import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,5,2,6,3,8,9);

        list.stream()
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
    }
}
