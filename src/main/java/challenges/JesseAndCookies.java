package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JesseAndCookies {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());

        int result = JesseAndCookiesResult.cookies(k, A);
        System.out.println("Result = " + result);
        bufferedReader.close();
    }
}

class JesseAndCookiesResult {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.addAll(A);
        int ans = 0;
        while (pq.peek() < k) {
            int c1 = pq.poll();
            int c2 = pq.poll();
            int newCookie = c1 + (2 * c2);
            if (pq.size() == 0 && newCookie < k) {
                ans = -1;
                break;
            }
            pq.add(newCookie);
            ans++;
        }
        return ans;
    }


}