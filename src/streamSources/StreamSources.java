package streamSources;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamSources {

    public static void main(String[] args) {
        //1. Sources from collections (Lists, Sets , HasMaps ..)

        //2. Empty source
        Stream<Integer> stream1 = Stream.empty(); //finite source

        //3. Source from factory method
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9); // finite source

        //4. Infinity source based on a supplier
        Supplier<Integer> sup = () -> new Random().nextInt();
        Stream<Integer> stream3 = Stream.generate(sup);  // infinite source

        //5. Using iterate
        Stream<Integer> stream4 = Stream.iterate(1, i->i+2); //infinite source
        Stream<Integer> stream5 = Stream.iterate(1, i->i<=10,i->i+2); //finite source

    }

}
