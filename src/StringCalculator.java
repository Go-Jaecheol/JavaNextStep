import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String[] tokens;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            tokens = m.group(2).split(customDelimeter);
        }
        else {
            tokens = text.split(",|:");
        }

        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
            if (numbers[i] < 0) {
                throw new RuntimeException();
            }
        }

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
