package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.
 * <p>
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
 * <p>
 * Example
 * <p>
 * There are  elements, two positive, two negative and one zero. Their ratios are 2/5 = 0.400000, 2/5 = 0.400000 and 1/5 = 0.200000
 * <p>
 * ,  and . Results are printed as:
 * <p>
 * 0.400000
 * 0.400000
 * 0.200000
 */

public class PlusMinusProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusResult.plusMinus(arr);

        bufferedReader.close();
    }

}

class PlusMinusResult {

    public static void plusMinus(List<Integer> arr) {
        var size = BigDecimal.valueOf(arr.size());

        //count the positives, negatives and zeroes
        long qtdPositives = arr.stream().filter(e -> e > 0).count();
        long qtdNegatives = arr.stream().filter(e -> e < 0).count();
        long qtdZeroes = arr.stream().filter(e -> e == 0).count();

        //using decimal to get precision and 6 decimal places
        var firstRatio = BigDecimal.valueOf(qtdPositives).divide(size, 6, RoundingMode.HALF_EVEN);
        var secondRatio = BigDecimal.valueOf(qtdNegatives).divide(size, 6, RoundingMode.HALF_EVEN);
        var thirdRatio = BigDecimal.valueOf(qtdZeroes).divide(size, 6, RoundingMode.HALF_EVEN);

        //print the result
        System.out.println(firstRatio);
        System.out.println(secondRatio);
        System.out.println(thirdRatio);

        arr.stream().sorted();

    }

}

