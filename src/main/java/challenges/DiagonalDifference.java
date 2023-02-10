package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 */

class DiagonalDifferenceResult {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(size - i - 1);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DiagonalDifferenceResult.diagonalDifference(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}