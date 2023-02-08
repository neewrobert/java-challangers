package challenges;

import java.io.*;

class TimeConversionResult {


    public static String timeConversion(String s) {
        Integer givenHour = Integer.parseInt(s.substring(0, 2));
        var suffix = s.substring(8);
        int convertedHour = 0;
        if(suffix.equalsIgnoreCase("PM") && givenHour < 12){
            convertedHour = givenHour + 12;

        } else if(suffix.equals("AM") && givenHour >= 12){
            convertedHour = givenHour - 12;
        }

        return String.format("%02d", convertedHour) + s.substring(2, 8);
    }

}

public class TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = TimeConversionResult.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
