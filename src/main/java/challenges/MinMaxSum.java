package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;


/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five
 * integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * Example
 * arr = [1, 3, 5, 7, 9 ]
 * The minimum sum is 1 + 3 + 5 + 7 = 16 and the maximum sum is 3 + 5 + 7 + 9 = 24 . The function prints: 16 24
 */
class Result {

    public static void miniMaxSum(List<Integer> arr) {

        //converting to long to avoid Integer overflow
        List<Long> arrLong = arr.stream().map(Long::valueOf).toList();
        Long min = arrLong.stream().sorted().limit(4).reduce(0L, Long::sum);
        Long max = arrLong.stream().sorted().skip(1).reduce(0L, Long::sum);

        System.out.println(min + " " + max);

    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
